/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.tesouraria.control;

import javax.servlet.http.HttpSession;
import org.br.tesouraria.model.DAO.modelDizimoDAO;
import org.br.tesouraria.view.manterDizimosModelView;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.br.tesouraria.model.DAO.modelMembrosDAO;
import org.br.tesouraria.model.DAO.modelUsuarioDAO;
import org.br.tesouraria.util.TimeLookup;
import org.br.tesouraria.view.manterMembrosModelView;
import org.br.tesouraria.view.manterUsuariosModelView;

/**
 *
 * @author Danilo
 */
//@WebServlet(name = "controlDizimos", urlPatterns = {"/WEB-INF/classes/org/br/tesouraria/control/controlDizimos.do"})
public class controlDizimos extends HttpServlet {

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
               
               manterDizimosModelView diz = new manterDizimosModelView();
     //          diz.setDataLancDiz(null);
//               TimeLookup.getInstance().pegarTempo(diz.getDataLancDiz()); dando erro no servidor
                
                
                int idKeyEstMembro = mbr.getIdMembro(); 

                manterUsuariosModelView usr = new manterUsuariosModelView();
                String loginUser = (String) session.getAttribute("loginUser");
                modelUsuarioDAO usrDAO = new modelUsuarioDAO();
                usr = usrDAO.lePorLogin(loginUser);
                
                request.setAttribute("usr", usr);
                request.setAttribute("mbr", mbr);
                request.setAttribute("diz", diz);
                RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterDizimos/exibicaoJSPinserirManterDizPorNome.jsp");
                rd.forward(request, response);
            }
            if(OPBD.equals("inserirPorId")){
                manterMembrosModelView mbr = new manterMembrosModelView();
                int idMembro = Integer.parseInt(request.getParameter("idMembro"));
                modelMembrosDAO mbrDAO = new modelMembrosDAO();
                mbr = mbrDAO.leId(idMembro);
                
                manterDizimosModelView diz  =new manterDizimosModelView();
                
                int idKeyEstMembro = mbr.getIdMembro();
                
                manterUsuariosModelView usr = new manterUsuariosModelView();
                String loginUser = (String) session.getAttribute("loginUser");
                modelUsuarioDAO usrDAO = new modelUsuarioDAO();
                usr = usrDAO.lePorLogin(loginUser);
                
                request.setAttribute("usr", usr);
                request.setAttribute("mbr",mbr);
                request.setAttribute("diz",diz);
                
                RequestDispatcher rd = request.getRequestDispatcher("ExibicaoJSP/ExibicaoJSP_manterDizimos/exibicaoJSPinserirManterDizPorId.jsp");
                rd.forward(request, response);                
                 
                 
            }
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
        if(OPBD.equals("inserirFinalizar"))
        {
            manterDizimosModelView diz = new manterDizimosModelView();
            diz.setIdKeyEstMembro(Integer.parseInt(request.getParameter("idKeyEstMembro")));
            diz.setIdKeyEstUsuario(Integer.parseInt(request.getParameter("idKeyEstUsuario")));
            diz.setValorDiz(Double.parseDouble(request.getParameter("valorDiz")));
            diz.setDataDiz(request.getParameter("dataDiz"));
            diz.setPeriodoDiz(request.getParameter("periodoDiz"));
            diz.setDataLancDiz(request.getParameter("dataLancDiz"));
                        
            DizimoDAO dizDAO= new DizimoDAO();
            dizDAO.grava(diz);
            
            response.sendRedirect("manterDizimos/manterDizimosInserirFormNomeMembro.jsp");
            
            
            
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
