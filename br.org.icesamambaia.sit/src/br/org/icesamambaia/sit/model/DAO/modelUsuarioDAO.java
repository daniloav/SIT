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
import org.br.tesouraria.view.manterUsuariosModelView;

/**
 *
 * @author Danilo
 */
public class modelUsuarioDAO {
    static modelUsuarioDAO instance =
            new modelUsuarioDAO();

    /**
     *
     * @return
     */
    public static modelUsuarioDAO getInstance() {
        return instance;
    }

    /**
     *
     */
    public modelUsuarioDAO() {
    }

    /**
     *
     * @param os
     * @return
     */
    @SuppressWarnings("empty-statement")
    public int grava(manterUsuariosModelView usr) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "INSERT INTO manterusuarios (nomeUser,telefoneUser,emailUser,cpfUser,loginUser,senhaUser)" +
                        " VALUES (?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, usr.getNomeUser());
                pstmt.setString(2, usr.getTelefoneUser());
                pstmt.setString(3, usr.getEmailUser());
                pstmt.setString(4,usr.getCpfUser());
                pstmt.setString(5,usr.getLoginUser());
                pstmt.setString(6,usr.getSenhaUser());
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
    
    public List<manterUsuariosModelView> leTodos() {

        Statement stmt = null;
        List<manterUsuariosModelView> LISTusr = new ArrayList<manterUsuariosModelView>();
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM manterusuarios ORDER BY idUser asc ");
                while (rs.next()) {
                    manterUsuariosModelView usr = new manterUsuariosModelView();
                    usr.setIdUser(rs.getInt("idUser"));
                    usr.setNomeUser(rs.getString("nomeUser"));
                    usr.setTelefoneUser(rs.getString("telefoneUser"));
                    usr.setEmailUser(rs.getString("emailUser"));
                    usr.setCpfUser(rs.getString("cpfUser"));                    
                    usr.setLoginUser(rs.getString("loginUser"));
                    usr.setSenhaUser(rs.getString("senhaUser"));
                    LISTusr.add(usr);
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
        return LISTusr;
    }
    public List<manterUsuariosModelView> leRelTodosUsuarios() {

        Statement stmt = null;
        List<manterUsuariosModelView> LISTusr = new ArrayList<manterUsuariosModelView>();
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM manterusuarios ");
                while (rs.next()) {
                    manterUsuariosModelView usr = new manterUsuariosModelView();
                    usr.setIdUser(rs.getInt("idUser"));
                    usr.setNomeUser(rs.getString("nomeUser"));
                    usr.setTelefoneUser(rs.getString("telefoneUser"));
                    usr.setEmailUser(rs.getString("emailUser"));
                    usr.setCpfUser(rs.getString("cpfUser"));                    
                    usr.setLoginUser(rs.getString("loginUser"));
                    usr.setSenhaUser(rs.getString("senhaUser"));
                    LISTusr.add(usr);
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
        return LISTusr;
    }
public List<manterUsuariosModelView> leTodosLogin() {

        Statement stmt = null;
        List<manterUsuariosModelView> LISTusr = new ArrayList<manterUsuariosModelView>();
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM manterusuarios ");
                while (rs.next()) {
                    manterUsuariosModelView usr = new manterUsuariosModelView();
                   
                    usr.setLoginUser(rs.getString("loginUser"));

                    LISTusr.add(usr);
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
        return LISTusr;
    }

   public manterUsuariosModelView le(String nomeUser) {

        Statement stmt = null;
        manterUsuariosModelView usr = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM manterusuarios where nomeUser like '%" + nomeUser + "%'");
                if (rs.next()) {
                    usr = carregaDadosNoObjeto(rs);
                } else {
                    usr = null;
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
        return(usr);

    }
   
   public manterUsuariosModelView lePorLogin(String loginUser) {

        Statement stmt = null;
        manterUsuariosModelView usr = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM manterusuarios where loginUser = '" + loginUser + "'");
                if (rs.next()) {
                    usr = carregaDadosNoObjeto(rs);
                } else {
                    usr = null;
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
        return(usr);

    }

    private manterUsuariosModelView carregaDadosNoObjeto(ResultSet rs) throws SQLException {

        manterUsuariosModelView usr = new manterUsuariosModelView();

       usr.setIdUser(rs.getInt("idUser"));
       usr.setNomeUser(rs.getString("nomeUser"));
       usr.setTelefoneUser(rs.getString("telefoneUser"));
       usr.setEmailUser(rs.getString("emailUser"));
       usr.setCpfUser(rs.getString("cpfUser"));                    
       usr.setLoginUser(rs.getString("loginUser"));
       usr.setSenhaUser(rs.getString("senhaUser"));
        return usr;

    }

    public int apaga(String idUser) {

        int n = 0;
        Statement stmt = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement();
                n = stmt.executeUpdate(
                        "DELETE FROM manterusuarios WHERE idUser = '" + idUser + "'");
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

    public int altera(manterUsuariosModelView usr) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "UPDATE manterusuarios SET " +
                        "nomeUser = ?, telefoneUser = ?, emailUser = ?, cpfUser = ?, loginUser = ?, " +
                        "senhaUser = ? " +
                        "where idUser = ? ");
                pstmt.setString(1,usr.getNomeUser());
                pstmt.setString(2,usr.getTelefoneUser());
                pstmt.setString(3,usr.getEmailUser());
                pstmt.setString(4,usr.getCpfUser());
                pstmt.setString(5,usr.getLoginUser());
                pstmt.setString(6,usr.getSenhaUser());
                pstmt.setInt(7,usr.getIdUser());
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


    public String pesquisar(String nomeUser) {

    
        Statement stmt = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM manterusuarios where nomeUser = '" +nomeUser+ "'");
                while (rs.next()) {


                    nomeUser = rs.getString("nomeUser");//vc escolheu o filtro, agora pega todos os campos no banco
                    String telefoneUser = rs.getString("telefoneUser");
                    String emailUser = rs.getString("emailUser");
                    String cpfUser = rs.getString("cpfUser");
                    String loginUser = rs.getString("loginUser");
                    String senhaUser = rs.getString("senhaUser");
                    int idUser = rs.getInt("idUser");
                    
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
        return nomeUser;
      }

   public manterUsuariosModelView pegaId(String loginUser, String senhaUser) {

        Statement stmt = null;
        manterUsuariosModelView usr = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM manterusuarios where loginUser = '" + loginUser + "'and senhaUser='"+senhaUser+"'");
                if (rs.next()) {
                    usr = carregaDadosNoObjeto(rs);
                } else {
                    usr = null;
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
        return usr;

    }

    
}
