package br.org.icesamambaia.sit.model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danilo
 */
public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();

    public static ConnectionFactory getInstance() {
        return instance;
    }

    private ConnectionFactory() {
    }

    public Connection criaConexao() {

        // modificar(descomentar) para utilizar em producao

        String driver = "com.mysql.jdbc.Driver";
        String strConexao = "jdbc:mysql://mysql.icesamambaia.org.br/icesamambaia13";        
        String usuario = "icesamambaia13";
        String senha = "salvation,11"; 
        
        /* modificar(descomentar) para utilizar  wampserver localmente*/
//        String driver = "com.mysql.jdbc.Driver";
//        String strConexao = "jdbc:mysql://localhost/icesamambaia13";
//        String usuario = "root";
//        String senha = ""; 
        
        
        

        Connection conn = null;

        try {
            Class.forName(driver);
            System.out.println("Driver registrado.");
            conn = DriverManager.getConnection(strConexao, usuario, senha);
            System.out.println("Conexão efetuada.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco nao encontrado.");
        } catch (SQLException ex) {
            System.out.print("Erro ao obter conexao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return conn;

    }
}
