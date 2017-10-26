package br.org.icesamambaia.sit.model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.org.icesamambaia.sit.model.Dizimo;
import br.org.icesamambaia.sit.view.manterDizimosModelView;

/**
 *
 * @author Danilo
 */
public class DizimoDAO {
    static DizimoDAO instance = new DizimoDAO();

    public static DizimoDAO getInstance() {
        return instance;
    }
    public DizimoDAO() {
    }
    @SuppressWarnings("empty-statement")
    public int grava(Dizimo diz) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "INSERT INTO dizimos (idDiz,idKeyEstMembro,idKeyEstUsuario,valorDiz,dataDiz,periodoDiz,dataLancDiz)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?)");
                pstmt.setInt(1, diz.getIdDiz());
                pstmt.setInt(2, diz.getIdKeyEstMembro());
                pstmt.setInt(3, diz.getIdKeyEstUsuario());
                pstmt.setDouble(4, diz.getValorDiz());
                pstmt.setString(5, diz.getDataDiz());
                pstmt.setString(6, diz.getPeriodoDiz());
                pstmt.setString(7, diz.getDataLancDiz());
                
                
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
    
      public Dizimo lePorIdMembro(int idMembro) {

        Statement stmt = null;
        Dizimo diz = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM manterdizimos where idKeyEstMembro = '" + idKeyEstMembro + "'");
                if (rs.next()) {
                    diz = carregaDadosNoObjeto(rs);
                } else {
                    diz = null;
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
        return(diz);
    }
      
      public Dizimo lePorIdDiz(int idDiz) {

        Statement stmt = null;
        Dizimo diz = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM manterdizimos where idDiz = '" + idDiz + "'");
                if (rs.next()) {
                    diz = carregaDadosNoObjeto(rs);
                } else {
                    diz = null;
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
        return(diz);
    }

    private Dizimo carregaDadosNoObjeto(ResultSet rs) throws SQLException {

        Dizimo diz = new Dizimo();

       diz.setIdDiz(rs.getInt("idDiz"));
       diz.setIdKeyEstMembro(rs.getInt("idKeyEstMembro"));
       diz.setIdKeyEstUsuario(rs.getInt("idKeyEstUsuario"));
       diz.setValorDiz(rs.getDouble("valorDiz"));
       diz.setDataDiz(rs.getString("dataDiz"));
       diz.setPeriodoDiz(rs.getString("periodoDiz"));
       diz.setDataLancDiz(rs.getString("dataLancDiz"));
        return diz;

    }

    public int apaga(String idDiz) {

        int n = 0;
        Statement stmt = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement();
                n = stmt.executeUpdate(
                        "DELETE FROM manterdizimos WHERE idDiz = '" + idDiz + "'");
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

    public int altera(Dizimo diz) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "UPDATE manterdizimos SET " +
                        "idKeyEstMembro = ? ,idKeyEstUsuario = ? ,valorDiz = ? ,dataDiz = ? ,periodoDiz = ? ,dataLancDiz = 1" +
                        "where idDiz = ? ");
                pstmt.setInt(1,diz.getIdKeyEstMembro());
                pstmt.setInt(2,diz.getIdKeyEstUsuario());
                pstmt.setDouble(3,diz.getValorDiz());
                pstmt.setString(4,diz.getDataDiz());
                pstmt.setString(5,diz.getPeriodoDiz());
                pstmt.setString(6,diz.getDataLancDiz());
                pstmt.setInt(7,diz.getIdDiz());
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


    
    
      public List<Dizimo> leTodos() {

        Statement stmt = null;
        List<Dizimo> ListaDiz = new ArrayList<Dizimo>();
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM dizimos ORDER BY dataLancDiz asc ");
                while (rs.next()) {
                    manterDizimosModelView diz = new manterDizimosModelView();
                    diz.setIdDiz(rs.getInt("idDiz"));
                    diz.setIdKeyEstMembro(rs.getInt("idKeyEstMembro"));
                    diz.setIdKeyEstUsuario(rs.getInt("idKeyEstUsuario"));
                    diz.setValorDiz(rs.getDouble("valorDiz"));
                    diz.setDataDiz(rs.getString("dataDiz"));                    
                    diz.setPeriodoDiz(rs.getString("periodoDiz"));
                    diz.setDataLancDiz(rs.getString("dataLancDiz"));
                    ListaDiz.add(diz);
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
        return ListaDiz;
    }

  

    
}


