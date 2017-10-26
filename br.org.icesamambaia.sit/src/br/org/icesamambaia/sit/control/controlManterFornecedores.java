/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.tesouraria.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.br.tesouraria.model.DAO.modelFornecedoresDAO;
import org.br.tesouraria.view.manterFornecedoresModelView;

/**
 *
 * @author Danilo
 */
//@WebServlet(name = "controlManterFornecedores", urlPatterns = {"/controlManterFornecedores.do"})
public class controlManterFornecedores extends HttpServlet {

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
PrintWriter out = response.getWriter();

        String OPBD = request.getParameter("OPBD");

        if (OPBD.equals("inserir")) {
            
            modelFornecedoresDAO opBanco = new modelFornecedoresDAO();
            Fornecedor forn = new Fornecedor();

            String nomeFornecedor = request.getParameter("nomeFornecedor").trim();
            forn.setCnpjFornecedor(request.getParameter("cnpjFornecedor".trim()));
            forn.setDescFornecedor(request.getParameter("descFornecedor").trim());
                   

            List<Fornecedor> LISTforn = modelFornecedoresDAO.getInstance().leTodos();
            for (int i = 0; i <= LISTforn.size() - 1; i++) {
                if (LISTforn.get(i).getNomeFornecedor().equals(nomeFornecedor)) {
                    out.print("<script>alert('Nome de Fornecedor já utilizado já utilizado');</script>");
                    out.println("<script>document.location.href='manterFornecedores/manterFornecedoresInserirForm.jsp';</script>");
                }
            }            

                forn.setNomeFornecedor(nomeFornecedor);
                opBanco.grava(forn);
                out.print("<script>alert('Cadastro efetuado com sucesso');</script>");
                out.println("<script>document.location.href='arquivosDeInicioIndex/index.jsp';</script>");
           
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
