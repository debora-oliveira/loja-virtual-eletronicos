package loja.virtual.db;

import java.sql.Connection;
import java.sql.SQLException;

import loja.virtual.model.Cliente;

public class TestaConexao {
	public static void main(String[] args) {
		
//		GenericDAOConexao daoConexao = new GenericDAOConexao();
//		Connection connection;
//		try {
//			connection = daoConexao.getConnection();
//			System.out.println("Conexao realizada");
//			connection.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		Cliente cliente = new Cliente();
		cliente.setEmail("email@email.com");
		cliente.setSenha("1234");
		cliente.setNome("Beltrana");
		cliente.setCpf("123.123.123.90");
		cliente.setTelefone("1234-9999");
		
		ClienteDAO clienteCAD;
		try {
			clienteCAD = new ClienteDAO();
			clienteCAD.cadastrarCliente(cliente);
			System.out.println("Cadastro de cliente realizado!");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de SQL!");
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}
}
