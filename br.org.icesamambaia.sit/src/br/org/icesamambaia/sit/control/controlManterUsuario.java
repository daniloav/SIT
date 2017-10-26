/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.tesouraria.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.br.tesouraria.model.DAO.modelUsuarioDAO;
import org.br.tesouraria.view.manterUsuariosModelView;

/**
 *
 * @author Danilo
 */
//@WebServlet(name = "controlManterUsuario", urlPatterns = {"/controlManterUsuario.do"})
public class controlManterUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String OPBD = request.getParameter("OPBD");

        if (OPBD.equals("inserir")) {

            modelUsuarioDAO opBanco = new modelUsuarioDAO();
            manterUsuariosModelView usr = new manterUsuariosModelView();

            usr.setNomeUser(request.getParameter("nomeUser").trim());
            usr.setTelefoneUser(request.getParameter("telefoneUser".trim()));
            usr.setEmailUser(request.getParameter("emailUser").trim());
            usr.setCpfUser(request.getParameter("cpfUser").trim());
            usr.setSenhaUser(request.getParameter("senhaUser").trim());
            usr.setConfirmaSenha(request.getParameter("confirmaSenha").trim());
            String login = request.getParameter("loginUser");

            List<manterUsuariosModelView> LISTusr = modelUsuarioDAO.getInstance().leTodos();
            for (int i = 0; i <= LISTusr.size() - 1; i++) {
                if (LISTusr.get(i).getLoginUser().equals(login)) {
                    out.print("<script>alert('Login já utilizado');</script>");
                    out.println("<script>document.location.href='manterUsuarios/manterUsuariosInserirForm.jsp';</script>");
                }
            }
            if (usr.getSenhaUser().equals(usr.getConfirmaSenha())) {

                usr.setLoginUser(login);
                opBanco.grava(usr);
                out.print("<script>alert('Cadastro efetuado com sucesso');</script>");
                out.println("<script>document.location.href='arquivosDeInicioIndex/index.jsp';</script>");
            }
            out.print("<script>alert('Confirmação de senha, não corresponde com a senha');</script>");
            out.println("<script>document.location.href='manterUsuarios/manterUsuariosInserirForm.jsp';</script>");
        }

    
    if (OPBD.equals("alterar")) {

            manterUsuariosModelView usr = modelUsuarioDAO.getInstance().le(request.getParameter("nomeUser"));
            if(usr==(null))//Verifica se o usuario existe na base de dados
            {
                out.print("<script>alert('Usuário não encontrado');</script>");
                  out.println("<script>document.location.href='manterUsuarios/manterUsuariosAlterarForm.jsp';</script>");
            
            }else{
             request.setAttribute("usr", usr);
            RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterUsuarios/exibicaoJSPalteraManterUsuarios.jsp");
            rd.forward(request, response);}

        }
        if (OPBD.equals("acaoAlterar")) {

            manterUsuariosModelView usr = new manterUsuariosModelView();
            modelUsuarioDAO opBanco = new modelUsuarioDAO();

            usr.setNomeUser(request.getParameter("nomeUser"));
            usr.setTelefoneUser(request.getParameter("telefoneUser"));
            usr.setEmailUser(request.getParameter("emailUser"));
            usr.setCpfUser(request.getParameter("cpfUser"));
            usr.setSenhaUser(request.getParameter("senhaUser"));
            String loginUser = request.getParameter("loginUser").trim();
            usr.setConfirmaSenha(request.getParameter("confirmaSenha").trim());
            usr.setIdUser(Integer.parseInt(request.getParameter("idUser")));
            
            
            List<manterUsuariosModelView> LISTusr = modelUsuarioDAO.getInstance().leTodosLogin();



            for (int i = 0; i <= LISTusr.size() - 1; i++) {

                if (LISTusr.get(i).getLoginUser().equals(loginUser)) {
                    out.print("<script>alert('Login já utilizado, para fazer alterações modifique o login');</script>");
                    out.println("<script>document.location.href='manterUsuarios/manterUsuariosAlterarForm.jsp';</script>");
                }

            }




            if (usr.getSenhaUser().equals(usr.getConfirmaSenha())) {

                usr.setLoginUser(loginUser);
                opBanco.altera(usr);
                out.print("<script>alert('Dados alterados com sucesso');</script>");
                out.println("<script>document.location.href='manterUsuarios/manterUsuariosAlterarForm.jsp';</script>");
            }


            out.print("<script>alert('Confirmação de senha, não corresponde com a senha');</script>");
            out.println("<script>document.location.href='manterUsuarios/manterUsuariosAlterarForm.jsp';</script>");

        }
        if (OPBD.equals("excluir")) {

            manterUsuariosModelView usr = modelUsuarioDAO.getInstance().le(request.getParameter("nomeUser"));
            request.setAttribute("usr", usr);
            RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterUsuarios/exibicaoJSPexcluiManterUsuarios.jsp");
            rd.forward(request, response);
        }

        if (OPBD.equals("acaoExcluir")) {

           
            modelUsuarioDAO opBanco = new modelUsuarioDAO();

            String idUser = request.getParameter("idUser");

            opBanco.apaga(idUser);

            out.print("<script>alert('Dados excluidos com sucesso');</script>");
            out.println("<script>document.location.href='arquivosDeInicioIndex/index.jsp';</script>");
        } else {
        }
                if (OPBD.equals("pesquisar")) {

            String nomeUser = request.getParameter("nomeUser").trim();
            manterUsuariosModelView usr = modelUsuarioDAO.getInstance().le(request.getParameter("nomeUser"));
            request.setAttribute("usr", usr);
            
                RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterUsuarios/exibicaoJSPpesquisaManterUsuarios.jsp");
            rd.forward(request, response);


        }

    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
