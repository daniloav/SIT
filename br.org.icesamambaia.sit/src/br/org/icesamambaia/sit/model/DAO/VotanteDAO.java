package br.org.icesamambaia.sit.model.DAO;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import br.org.icesamambaia.sit.model.Cargo;
import br.org.icesamambaia.sit.model.Votante;

/**
 *
 * @author Danilo
 */
public class VotanteDAO {
	static VotanteDAO instance = new VotanteDAO();

	public static VotanteDAO getInstance() {
		return instance;
	}

	public VotanteDAO() {
	}

	public Votante le(String autLoginUser) {

		Statement stmt = null;
		Votante vt = null;
		Connection conn = ConnectionFactory.getInstance().criaConexao();
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM votante where login = '" + autLoginUser + "'");
				if (rs.next()) {
					vt = carregaDadosNoObjeto(rs);

				} else {
					vt = null;
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
		return (vt);

	}

	private Votante carregaDadosNoObjeto(ResultSet rs) throws SQLException {
		Cargo cargo = CargoDAO.getInstance().le(rs.getString("nome"));
		Votante vt = new Votante(rs.getInt("id"), rs.getString("nome"), rs.getString("sobreNome"),
				new java.util.Date(rs.getTimestamp("dataNascimento").getTime()),
				new java.util.Date(rs.getTimestamp("dataIngresso").getTime()), rs.getString("email"),
				rs.getString("telefone"), rs.getString("celular"), rs.getString("login"), rs.getString("senha"), cargo,
				rs.getString("cpf"));
		return vt;
	}

	public int grava(Votante vt) {
		int n = 0;
		Connection conn = ConnectionFactory.getInstance().criaConexao();
		Cargo cargo = CargoDAO.getInstance().le(vt.getCargo().getNomeCargo());
		if (conn != null) {
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(
						"insert into votante(nome,sobreNome,dataNascimento,dataIngresso,email,telefone,celular,login,senha,id_cargo,cpf)"
								+ "values(?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1, vt.getNome());
				pstmt.setString(2, vt.getSobreNome());
				pstmt.setTimestamp(3, new Timestamp(vt.getDataNascimento().getTime()));
				pstmt.setTimestamp(4, new Timestamp(vt.getDataIngresso().getTime()));
				pstmt.setString(5, vt.getEmail());
				pstmt.setString(6, vt.getTelefone());
				pstmt.setString(7, vt.getCelular());
				pstmt.setString(8, vt.getLogin());
				pstmt.setString(9, vt.getSenha());
				pstmt.setInt(10, cargo.getId());
				pstmt.setString(11, vt.getCpf());

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Inclusão falhou!!!\n" + e.getMessage());
			}
		}
		return n;
	}

	public int altera(Votante vt) {
		int n = 0;
		Connection conn = ConnectionFactory.getInstance().criaConexao();
		Cargo cargo = CargoDAO.getInstance().le(vt.getCargo().getNomeCargo());
		if (conn != null) {
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement("update votante set "+
						"nome=?,sobreNome=?,dataNascimento=?,dataIngresso=?,email=?,telefone=?,celular=?,login=?,senha=?,id_cargo=?,cpf=?"+
						"where nome=?");
				
				pstmt.setString(1, vt.getNome());
				pstmt.setString(2, vt.getSobreNome());
				pstmt.setTimestamp(3, new Timestamp(vt.getDataNascimento().getTime()));
				pstmt.setTimestamp(4, new Timestamp(vt.getDataIngresso().getTime()));
				pstmt.setString(5, vt.getEmail());
				pstmt.setString(6, vt.getTelefone());
				pstmt.setString(7, vt.getCelular());
				pstmt.setString(8, vt.getLogin());
				pstmt.setString(9, vt.getSenha());
				pstmt.setInt(10, cargo.getId());
				pstmt.setString(11, vt.getCpf());
				pstmt.setString(12,vt.getNome());
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Alteracao falhou!!!!" + e.getMessage());
			}
		}
		return n;

	}

}
