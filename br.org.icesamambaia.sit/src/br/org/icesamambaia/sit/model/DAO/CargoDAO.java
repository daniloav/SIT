package br.org.icesamambaia.sit.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.org.icesamambaia.sit.model.Cargo;

public class CargoDAO {
	static CargoDAO instance = new CargoDAO();
	
	public static CargoDAO getInstance() {
		return instance;
	}

	public CargoDAO() {}
	
	public Cargo le(String nome) {
		Statement stmt = null;
		Cargo cg = null;
		Connection conn = ConnectionFactory.getInstance().criaConexao();
		if(conn!=null) {
			try {
				stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from cargo where nome='"+nome+"'");
				if(rs.next()) {
					cg.setNomeCargo(rs.getString("nome"));
					cg.setNivel(rs.getInt("nivel"));
					cg.setId(rs.getInt("id"));
				}else {}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cg;
		}
}
