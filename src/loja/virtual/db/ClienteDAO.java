package loja.virtual.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void pesquisaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
}
