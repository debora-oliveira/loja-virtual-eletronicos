package loja.virtual.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceGenericDAOConexao {
	public Connection getConnection() throws ClassNotFoundException, SQLException; 
}
