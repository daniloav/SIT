    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.tesouraria.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.br.tesouraria.view.manterMembrosModelView;
import org.br.tesouraria.view.manterUsuariosModelView;

/**
 *
 * @author Danilo
 */
public class modelMembrosDAO {
    static modelMembrosDAO instance =
            new modelMembrosDAO();

    /**
     *
     * @return
     */
    public static modelMembrosDAO getInstance() {
        return instance;
    }

    /**
     *
     */
    public modelMembrosDAO() {
    }

    /**
     *
     * @param os
     * @return
     */
    @SuppressWarnings("empty-statement")
    public int grava(manterMembrosModelView mbr) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "INSERT INTO mantermembros (nomeMembro,dataNascMembro,cpfMembro,cargoMembro,fotoMembro)" +
                        " VALUES (?, ?, ?, ?, ?)");
                pstmt.setString(1, mbr.getNomeMembro());
                pstmt.setString(2, mbr.getDataNascMembro());
                pstmt.setString(3, mbr.getCpfMembro());
                pstmt.setString(4,mbr.getCargoMembro());
                pstmt.setString(5,mbr.getFotoMembro());
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
    
      public manterMembrosModelView le(String nomeMembro) {

        Statement stmt = null;
        manterMembrosModelView mbr = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM mantermembros where nomeMembro like '%" + nomeMembro + "%'");
                if (rs.next()) {
                    mbr = carregaDadosNoObjeto(rs);
                } else {
                    mbr = null;
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return(mbr);

    }

      public manterMembrosModelView leId(int idMembro) {

        Statement stmt = null;
        manterMembrosModelView mbr = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM mantermembros where idMembro = '" + idMembro + "'");
                if (rs.next()) {
                    mbr = carregaDadosNoObjeto(rs);
                } else {
                    mbr = null;
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return(mbr);

    }
    private manterMembrosModelView carregaDadosNoObjeto(ResultSet rs) throws SQLException {

        manterMembrosModelView mbr = new manterMembrosModelView();

       mbr.setIdMembro(rs.getInt("idMembro"));
       mbr.setNomeMembro(rs.getString("nomeMembro"));
       mbr.setDataNascMembro(rs.getString("dataNascMembro"));
       mbr.setCpfMembro(rs.getString("cpfMembro"));
       mbr.setCargoMembro(rs.getString("cargoMembro"));
       mbr.setFotoMembro(rs.getString("fotoMembro"));
        return mbr;

    }

    public int apaga(String idMembro) {

        int n = 0;
        Statement stmt = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement();
                n = stmt.executeUpdate(
                        "DELETE FROM mantermembros WHERE idMembro = '" + idMembro + "'");
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
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

    public int altera(manterMembrosModelView mbr) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "UPDATE mantermembros SET " +
                        "nomeMembro = ?, dataNascMembro = ?, cpfMembro = ?, cargoMembro = ? " +
                        "where idMembro = ? ");
                
                pstmt.setString(1,mbr.getNomeMembro());
                pstmt.setString(2,mbr.getDataNascMembro());
                pstmt.setString(3,mbr.getCpfMembro());
                pstmt.setString(4,mbr.getCargoMembro());
                pstmt.setInt(5,mbr.getIdMembro());
                
                n = pstmt.executeUpdate();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
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


    public String pesquisar(String nomeMembro) {

    
        Statement stmt = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM mantermembro where nomeMembro = '" +nomeMembro+ "'");
                while (rs.next()) {


                    nomeMembro = rs.getString("nomeMembro");//vc escolheu o filtro, agora pega todos os campos no banco
                    String dataNascMembro = rs.getString("dataNascMembro");
                    String cpfMembro = rs.getString("cpfMembro");
                    String cargoMembro = rs.getString("cargoMembro");
                    String fotoMembro = rs.getString("fotoMembro");
                    int idMembro = rs.getInt("idUser");
                    
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return nomeMembro;
      }
    
      public List<manterMembrosModelView> leTodos() {

        Statement stmt = null;
        List<manterMembrosModelView> LISTmbr = new ArrayList<manterMembrosModelView>();
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM mantermembros ORDER BY idMembro asc ");
                while (rs.next()) {
                    manterMembrosModelView mbr = new manterMembrosModelView();
                    mbr.setIdMembro(rs.getInt("idMembro"));
                    mbr.setNomeMembro(rs.getString("nomeMembro"));
                    mbr.setDataNascMembro(rs.getString("dataNascMembro"));
                    mbr.setCpfMembro(rs.getString("cpfMembro"));
                    mbr.setCargoMembro(rs.getString("cargoMembro"));                    
                    mbr.setFotoMembro(rs.getString("fotoMembro"));
                    LISTmbr.add(mbr);
                    }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return LISTmbr;
    }

  

    
}

