/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.tesouraria.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.br.tesouraria.model.DAO.modelDizimoDAO;
import org.br.tesouraria.model.DAO.modelFornecedoresDAO;
import org.br.tesouraria.model.DAO.modelMembrosDAO;
import org.br.tesouraria.model.DAO.modelSaidasDAO;
import org.br.tesouraria.model.DAO.modelUsuarioDAO;
import org.br.tesouraria.view.manterDizimosModelView;
import org.br.tesouraria.view.manterFornecedoresModelView;
import org.br.tesouraria.view.manterMembrosModelView;
import org.br.tesouraria.view.manterSaidasModelView;
import org.br.tesouraria.view.manterUsuariosModelView;

/**
 *
 * @author Danilo
 */
//@WebServlet(name = "controlSaidas", urlPatterns = {"/controlSaidas.do"})
public class controlSaidas extends HttpServlet {    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String OPBD = null;
        OPBD = request.getParameter("OPBD");
        HttpSession session = request.getSession();
         try {
            if (OPBD.equals("inserirPorNome")) {
                manterMembrosModelView mbr = new manterMembrosModelView();
                String nomeMembro = request.getParameter("nomeMembro");
                modelMembrosDAO mbrDAO = new modelMembrosDAO();
                mbr = mbrDAO.le(nomeMembro);
                
                Fornecedor forn = new Fornecedor();
                String nomeFornecedor = request.getParameter("nomeFornecedor");
                modelFornecedoresDAO fornDAO = new modelFornecedoresDAO();
                forn = fornDAO.lePorNome(nomeFornecedor);

                int idKeyMembrosSolicitante = mbr.getIdMembro();

                manterUsuariosModelView usr = new manterUsuariosModelView();
                String loginUser = (String) session.getAttribute("loginUser");
                modelUsuarioDAO usrDAO = new modelUsuarioDAO();
                usr = usrDAO.lePorLogin(loginUser);
                
                request.setAttribute("usr", usr);
                request.setAttribute("mbr", mbr);
                request.setAttribute("forn", forn);
                RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterSaidas/exibicaoJSPinserirManterSaidasPorNome.jsp");
                rd.forward(request, response);
            }
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
        if(OPBD.equals("inserirFinalizar"))
        {
            manterSaidasModelView sai = new manterSaidasModelView();
            sai.setIdKeyEstUsuariosLancador(Integer.parseInt(request.getParameter("idKeyEstUsuariosLancador")));
            sai.setIdKeyMembrosSolicitante(Integer.parseInt(request.getParameter("idKeyMembrosSolicitante")));
            sai.setIdKeyEstFornecedoresComprado(Integer.parseInt(request.getParameter("idKeyEstFornecedoresComprado")));
            sai.setNumNfSaida(request.getParameter("numNfSaida"));
            sai.setDataNfSaida(request.getParameter("dataNfSaida"));
            sai.setDataLancamentoNfSaida(request.getParameter("dataLancamentoNfSaida"));
            sai.setPeriodoLancamentoNfSaida(request.getParameter("periodoLancamentoNfSaida"));
            sai.setDescricaoSaida(request.getParameter("descricaoSaida"));
            sai.setTipoSaida(request.getParameter("tipoSaida"));
                        
            modelSaidasDAO saiDAO= new modelSaidasDAO();
            saiDAO.grava(sai);
            
            response.sendRedirect("manterSaidas/manterSaidasIndex.jsp");
            
            
            
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
