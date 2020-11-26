package loja.virtual.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionJDBC {
	//por enquanto apenas testando
	public static void main(String[] args) {
		// parametros para se conectar no banco
		String driver = "mysql";
		String dataBaseAddress = "localhost";
		String dataBaseName = "lvEletronicos";
		//criei um usuario a parte
		String user = "ADMIN";
		String password = "password";
		//construindo string de conexao 
		StringBuilder sb = new StringBuilder("jdbc:").append(driver)
				.append("://").append(dataBaseAddress).append("/")
				.append(dataBaseName);
		
		String connectionUrl = sb.toString();
		
		//criar conexao usando driverManager, passando como parametros a string de conexao, usuario e senha
		try(Connection conn = DriverManager.getConnection(connectionUrl,user,password)){
			System.out.println("SUCESSO ao se conectar ao banco MySQL!");
		}catch (SQLException e) {
			System.out.println("FALHA ao se conectar ao banco MYSQL");
			e.printStackTrace();
		}
	}	
}


