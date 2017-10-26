/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.tesouraria.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.br.tesouraria.view.manterSaidasModelView;

/**
 *
 * @author Danilo
 */
public class modelSaidasDAO {
    static modelSaidasDAO instance =
            new modelSaidasDAO();

    /**
     *
     * @return
     */
    public static modelSaidasDAO getInstance() {
        return instance;
    }

    /**
     *
     */
    public modelSaidasDAO() {
    }

    /**
     *
     * @param os
     * @return
     */
    @SuppressWarnings("empty-statement")
    public int grava(manterSaidasModelView sai) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "INSERT INTO mantersaidas (idKeyEstUsuariosLancador,idKeyMembrosSolicitante,idKeyEstFornecedoresComprado,numNfSaida,dataNfSaida,dataLancamentoNfSaida,periodoLancamentoNfSaida,descricaoSaida,tipoSaida)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setInt(1, sai.getIdKeyEstUsuariosLancador());
                pstmt.setInt(2, sai.getIdKeyMembrosSolicitante());
                pstmt.setInt(3, sai.getIdKeyEstFornecedoresComprado());
                pstmt.setString(4,sai.getNumNfSaida());
                pstmt.setString(5,sai.getDataNfSaida());
                pstmt.setString(6,sai.getDataLancamentoNfSaida());
                pstmt.setString(7,sai.getPeriodoLancamentoNfSaida());
                pstmt.setString(8,sai.getDescricaoSaida());
                pstmt.setString(9,sai.getTipoSaida());
                n = pstmt.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Inclusao Falhou!!!\n" + e.getMessage());


            }

            finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return n;

    }
    
      
  

    
}


