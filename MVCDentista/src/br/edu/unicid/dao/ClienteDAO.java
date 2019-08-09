package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.edu.unicid.bean.Cliente;
import br.edu.unicid.util.ConnectionFactory;

public class ClienteDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Cliente cliente;

	public ClienteDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	public void salvar(Cliente cliente) throws Exception {
		if (cliente == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO cad_cliente (cdcliente, " + "nomecliente, emailcliente, dtaNasc, "
					+ "idadecliente, endcliente, estadoCivil, telefone, convenio)" + "values (?,?,?,?,?,?,?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cliente.getcdCliente());
			ps.setString(2, cliente.getnomeCliente());
			ps.setString(3, cliente.getemailCliente());
			ps.setDate(4,  new java.sql.Date(cliente.getDtaNasc().getTime()));
			ps.setInt(5, cliente.getidadeCliente());
			ps.setString(6, cliente.getendCliente());
			ps.setString(7, cliente.getEstadoCivil());
			ps.setInt(8, cliente.getTelefone());
			ps.setBoolean(9, cliente.isConvenio());

			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	public Cliente procurarcliente(int cdCliente) throws Exception {
		try {
			String SQL = "SELECT  * FROM cad_cliente WHERE cdCliente=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cdCliente);
			rs = ps.executeQuery();
			if (rs.next()) {
				int cd = rs.getInt(1);
				String nome = rs.getString("nomeCliente");
				String email = rs.getString("emailCliente");
				Date nascimento = rs.getDate(4);
				int idade = rs.getInt("idadeCliente");
				String endereco = rs.getString(6);
				String estadoCivil = rs.getString("estadoCivil");
				int telefone = rs.getInt("telefone");
				boolean convenio = rs.getBoolean("convenio");
				cliente = new Cliente(cd, nome, email, nascimento, idade, endereco, estadoCivil, telefone, convenio);
			}
			return cliente;

		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	public void excluir(int cdCliente) throws Exception {
		try {
			String SQL = "DELETE FROM cad_cliente WHERE cdCliente=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cdCliente);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	public void atualizar(Cliente cliente) throws Exception {
		if (cliente == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE cad_cliente set nomecliente=?, emailcliente=?, dtaNasc=?, "
					+ "idadecliente=?, endcliente=?, estadoCivil=?, telefone=?, convenio=? "
					+ "WHERE cdCliente=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getnomeCliente());
			ps.setString(2, cliente.getemailCliente()); 
			ps.setDate(3, new java.sql.Date(cliente.getDtaNasc().getTime()));
			ps.setInt(4, cliente.getidadeCliente());
			ps.setString(5, cliente.getendCliente());
			ps.setString(6, cliente.getEstadoCivil());
			ps.setInt(7, cliente.getTelefone());
			ps.setBoolean(8, cliente.isConvenio());
			ps.setInt(9, cliente.getcdCliente());
			ps.executeUpdate();

			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		
	}
}
