package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.unicid.bean.*;
import br.edu.unicid.util.ConnectionFactory;

public class ServicoDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Servico Servico;

	public ServicoDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	public void salvar(Servico Servico) throws Exception {
		if (Servico == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO cad_Servico (cdOrca, Descricao, Preco)" + " values (?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, Servico.getCdOrca());
			ps.setString(2, Servico.getDescricao());
			ps.setDouble(3, Servico.getPreco());

			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public Servico procurarServico(int cdOrca) throws Exception {
		try {
			String SQL = "SELECT  * FROM cad_Servico WHERE cdOrca=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cdOrca);
			rs = ps.executeQuery();
			if (rs.next()) {
				int cd = rs.getInt(1);
				String Descricao = rs.getString("descricao");
				Double preco = rs.getDouble("preco");
				Servico = new Servico(cd, Descricao, preco);
			}
			return Servico;

		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public void excluir(int cdServico) throws Exception {
		try {
			String SQL = "DELETE FROM cad_Servico WHERE cdOrca=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cdServico);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public void atualizar(Servico Servico) throws Exception {
		if (Servico == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE cad_Servico set descricao=?, preco=? "
					+ "WHERE cdOrca=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, Servico.getDescricao());
			ps.setDouble(2, Servico.getPreco());
			ps.setInt(3, Servico.getCdOrca());
			ps.executeUpdate();

			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		
	}
	
	public void Calcular(double Preco) {
		
	}
	
	
	
	
	public List<Servico> listaServico() throws Exception{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Servico> Servicos = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cad_servico");
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				
				Servico Servico = new Servico();
				
				Servico.setCdOrca(rs.getInt("cdorca"));
				Servico.setDescricao(rs.getString("descricao"));
				Servico.setPreco(rs.getDouble("preco"));
				Servicos.add(Servico);
			}
			
		} 
			catch (SQLException ex) {
			Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
			
			return Servicos;
	}
	
	public Servico procurarOrcamento(String descricao) throws Exception {
		try {
			String SQL = "SELECT  * FROM cad_Servico WHERE descricao=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(2, descricao);
			rs = ps.executeQuery();
			if (rs.next()) {
				int cd = rs.getInt("cdorca");
				String Descricao = rs.getString(2);
				Double preco = rs.getDouble("preco");
				Servico = new Servico(cd, Descricao, preco);
			}
			return Servico;

		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	
	
	
	
}
