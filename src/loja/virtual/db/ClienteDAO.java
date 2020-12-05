package loja.virtual.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import loja.virtual.model.Cliente;
import loja.virtual.model.User;

public class ClienteDAO implements InterfaceClienteDAO {

	private Connection conexao;
	
	
	public ClienteDAO() throws ClassNotFoundException, SQLException {
		GenericDAOConexao daoConexao = new GenericDAOConexao();
		conexao = daoConexao.getConnection();
	}
	
	@Override
	public User validarLogin(String email, String senha) {

		return null;
	}

	@Override
	public void insereCliente(Cliente cliente) {
		try {
			String query = "{CALL insereCliente (?, ?, ?, ?, ?)}";
			CallableStatement stmt = conexao.prepareCall(query);
					stmt.setString(1, cliente.getEmail());
					stmt.setString(2, cliente.getSenha());
					stmt.setString(3, cliente.getNome());
					stmt.setString(4, cliente.getCpf());
					stmt.setString(5, cliente.getTelefone());
					stmt.executeQuery();
					conexao.close();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

//	@Override
//	public List<Cliente> pesquisaCliente(String nome) {
//		List<Cliente> listaClientes = new LinkedList<Cliente>();
//
//		try {
//			String sql = "SELECT cliente.id, cliente.nome, cliente.cpf, cliente.telefone, cliente.idUser, usuario.email, usuario.senha"
//					+ " FROM cliente, usuario where cliente.iduser = usuario.id"
//					+ " and cliente.nome like ?";
//			PreparedStatement stmt = conexao.prepareStatement(sql);
//			stmt.setString(1, '%' + nome + '%');
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Cliente cliente = new Cliente();
//				cliente.setId(rs.getLong("id"));
//				cliente.setNome(rs.getString("nome"));
//				cliente.setCpf(rs.getString("cpf"));
//				cliente.setTelefone(rs.getString("telefone"));
//				cliente.setEmail(rs.getString("email"));
//				cliente.setSenha(rs.getString("senha"));
//				listaClientes.add(cliente);
//			}
//			rs.close();
//			conexao.close();
//		} catch (SQLException e) {
//			System.out.println("Erro de SQL");
//			System.out.println(e);
//		}
//		return listaClientes;
//		
//	}

	
	@Override
	public List<Cliente> pesquisaTodosClientes() {
		List<Cliente> listaClientes = new LinkedList<Cliente>();
		try {
			String sql = "SELECT cliente.id, cliente.nome, cliente.cpf, cliente.telefone, cliente.idUser, usuario.email, usuario.senha"
					+ " FROM cliente, usuario where cliente.iduser = usuario.id;";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				listaClientes.add(cliente);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro de SQL");
			System.out.println(e);
		}
		
		return listaClientes;
	}
	
}
