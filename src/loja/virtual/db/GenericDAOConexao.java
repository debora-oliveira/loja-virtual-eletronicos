package loja.virtual.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GenericDAOConexao implements InterfaceGenericDAOConexao {
	//por enquanto apenas testando
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// parametros para se conectar no banco
		String driver = "mysql";
		String dataBaseAddress = "localhost";
		String dataBaseName = "lojavirtualeletronico";
		//criei um usuario a parte
		String user = "root";
		String password = "senha1234";
		//construindo string de conexao 
		StringBuilder sb = new StringBuilder("jdbc:")
				.append(driver)
				.append("://").append(dataBaseAddress).append("/")
				.append(dataBaseName);
		String connectionUrl = sb.toString();
		// jdbc:mysql://localhost:lojavirtualeletronico
		
		return DriverManager.getConnection(connectionUrl,user,password);
		
		//criar conexao usando driverManager, passando como parametros a string de conexao, usuario e senha
		//		try(Connection conn = DriverManager.getConnection(connectionUrl,user,password)){
//			System.out.println("SUCESSO ao se conectar ao banco MySQL!");
//		}catch (SQLException e) {
//			System.out.println("FALHA ao se conectar ao banco MYSQL");
//			e.printStackTrace();
//		}
		
	}
	


}
