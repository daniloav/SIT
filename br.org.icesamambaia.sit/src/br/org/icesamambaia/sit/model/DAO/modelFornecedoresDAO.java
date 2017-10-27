/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.br.tesouraria.view.manterFornecedoresModelView;

/**
 *
 * @author Danilo
 */
public class modelFornecedoresDAO {
    static modelFornecedoresDAO instance =
            new modelFornecedoresDAO();

    /**
     *
     * @return
     */
    public static modelFornecedoresDAO getInstance() {
        return instance;
    }

    /**
     *
     */
    public modelFornecedoresDAO() {
    }

    /**
     *
     * @param os
     * @return
     */
    @SuppressWarnings("empty-statement")
    public int grava(Fornecedor forn) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "INSERT INTO manterfornecedores (nomeFornecedor,cnpjFornecedor,descFornecedor)" +
                        " VALUES (?, ?, ?)");
                pstmt.setString(1, forn.getNomeFornecedor());
                pstmt.setString(2, forn.getCnpjFornecedor());
                pstmt.setString(3, forn.getDescFornecedor());
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
    
      public Fornecedor lePorNome(String nomeFornecedor) {

        Statement stmt = null;
        Fornecedor forn = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM manterfornecedores where nomeFornecedor = '" + nomeFornecedor + "'");
                if (rs.next()) {
                    forn = carregaDadosNoObjeto(rs);
                } else {
                    forn = null;
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
        return(forn);

    }

    private Fornecedor carregaDadosNoObjeto(ResultSet rs) throws SQLException {

        Fornecedor forn = new Fornecedor();

       forn.setIdFornecedor(rs.getInt("idFornecedor"));
       forn.setNomeFornecedor(rs.getString("nomeFornecedor"));
       forn.setCnpjFornecedor(rs.getString("cnpjFornecedor"));
       forn.setDescFornecedor(rs.getString("descFornecedor"));
       return forn;

    }

    public int apaga(String idFornecedor) {

        int n = 0;
        Statement stmt = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement();
                n = stmt.executeUpdate(
                        "DELETE FROM manterfornecedores WHERE idFornecedor = '" + idFornecedor + "'");
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

    public int altera(Fornecedor forn) {

        int n = 0;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(
                        "UPDATE manterfornecedores SET " +
                        "nomeFornecedor = ?, cnpjFornecedor = ?, descFornecedor = ?" +
                        "where idFornecedor = ? ");
                pstmt.setString(1,forn.getNomeFornecedor());
                pstmt.setString(2,forn.getCnpjFornecedor());
                pstmt.setString(3,forn.getDescFornecedor());
                pstmt.setInt(4,forn.getIdFornecedor());
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


    public String pesquisar(String nomeFornecedor) {

    
        Statement stmt = null;
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM manterfornecedores where nomeFornecedor = '" +nomeFornecedor+ "'");
                while (rs.next()) {


                    nomeFornecedor = rs.getString("nomeFornecedor");//vc escolheu o filtro, agora pega todos os campos no banco
                    String cnpjFornecedor = rs.getString("cnpjFornecedor");
                    String descFornecedores = rs.getString("descFornecedor");
                    int idFornecedor = rs.getInt("idFornecedor");
                    
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
        return nomeFornecedor;
      }
    
      public List<Fornecedor> leTodos() {

        Statement stmt = null;
        List<Fornecedor> LISTforn = new ArrayList<Fornecedor>();
        Connection conn = ConnectionFactory.getInstance().criaConexao();

        if (conn != null) {
            try {
                stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM manterfornecedores ORDER BY idFornecedor asc ");
                while (rs.next()) {
                    Fornecedor forn = new Fornecedor();
                    forn.setIdFornecedor(rs.getInt("idFornecedor"));
                    forn.setNomeFornecedor(rs.getString("nomeFornecedores"));
                    forn.setCnpjFornecedor(rs.getString("cnpjFornecedor"));
                    forn.setDescFornecedor(rs.getString("descFornecedor"));
                    LISTforn.add(forn);
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
        return LISTforn;
    }

  

}