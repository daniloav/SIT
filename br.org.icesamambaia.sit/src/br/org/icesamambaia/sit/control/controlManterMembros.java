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
import org.br.tesouraria.model.DAO.modelMembrosDAO;
import org.br.tesouraria.model.DAO.modelUsuarioDAO;
import org.br.tesouraria.view.manterMembrosModelView;
import org.br.tesouraria.view.manterUsuariosModelView;

/**
 *
 * @author Danilo
 */
//@WebServlet(name = "controlManterMembros", urlPatterns = {"/controlManterMembros.do"})
public class controlManterMembros extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String OPBD = request.getParameter("OPBD");

        if (OPBD.equals("inserir")) {

            modelMembrosDAO opBanco = new modelMembrosDAO();
            manterMembrosModelView mbr = new manterMembrosModelView();

            String nomeMembro = request.getParameter("nomeMembro").trim();
            mbr.setDataNascMembro(request.getParameter("dataNascMembro".trim()));
            mbr.setCpfMembro(request.getParameter("cpfMembro").trim());
            mbr.setCargoMembro(request.getParameter("cargoMembro").trim());
            mbr.setFotoMembro(request.getParameter("fotoMembro").trim());
         

            List<manterMembrosModelView> LISTmbr = modelMembrosDAO.getInstance().leTodos();
            for (int i = 0; i <= LISTmbr.size() - 1; i++) {
                if (LISTmbr.get(i).getNomeMembro().equals(nomeMembro)) {
                    out.print("<script>alert('Nome de Membro já utilizado já utilizado');</script>");
                    out.println("<script>document.location.href='manterUsuarios/manterUsuariosInserirForm.jsp';</script>");
                }
            }            

                mbr.setNomeMembro(nomeMembro);
                opBanco.grava(mbr);
                out.print("<script>alert('Cadastro efetuado com sucesso');</script>");
                out.println("<script>document.location.href='arquivosDeInicioIndex/index.jsp';</script>");
           
        }

    
    if (OPBD.equals("alterar")) {

            manterMembrosModelView mbr = modelMembrosDAO.getInstance().le(request.getParameter("nomeMembro"));
             request.setAttribute("mbr", mbr);
            RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterMembros/exibicaoJSPalteraManterMembros.jsp");
            rd.forward(request, response);

        }
        if (OPBD.equals("acaoAlterar")) {

            manterMembrosModelView mbr = new manterMembrosModelView();
            modelMembrosDAO opBanco = new modelMembrosDAO();

            mbr.setNomeMembro(request.getParameter("nomeMembro"));
            mbr.setDataNascMembro(request.getParameter("dataNascMembro"));
            mbr.setCpfMembro(request.getParameter("cpfMembro"));
            mbr.setCargoMembro(request.getParameter("cargoMembro"));            
            mbr.setIdMembro(Integer.parseInt(request.getParameter("idMembro")));
            mbr.setFotoMembro(request.getParameter("fotoMembro"));
            
            opBanco.altera(mbr);
            
            

                out.print("<script>alert('Dados alterados com sucesso');</script>");
                out.println("<script>document.location.href='manterMembros/manterMembrosAlterarForm.jsp';</script>");

        }
        if (OPBD.equals("excluir")) {

            manterMembrosModelView mbr = modelMembrosDAO.getInstance().le(request.getParameter("nomeMembro"));
            request.setAttribute("mbr", mbr);
            RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterMembros/exibicaoJSPexcluiManterMembros.jsp");
            rd.forward(request, response);
            
        }

        if (OPBD.equals("acaoExcluir")) {

           
            modelMembrosDAO opBanco = new modelMembrosDAO();

            String idMembro = request.getParameter("idMembro");

            opBanco.apaga(idMembro);

            out.print("<script>alert('Dados excluidos com sucesso');</script>");
            out.println("<script>document.location.href='arquivosDeInicioIndex/index.jsp';</script>");
        } else {
        }
                if (OPBD.equals("pesquisar")) {

            String nomeMembro = request.getParameter("nomeMembro").trim();
            manterMembrosModelView mbr = modelMembrosDAO.getInstance().le(request.getParameter("nomeMembro"));
            request.setAttribute("mbr", mbr);
            
                RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterMembros/exibicaoJSPpesquisaManterMembros.jsp");
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
