package loja.virtual.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import loja.virtual.model.Produto;


public class ProdutoDAO implements InterfaceProdutoDAO {
	private Connection conexao;

	public ProdutoDAO() throws ClassNotFoundException, SQLException {
		GenericDAOConexao daoConexao = new GenericDAOConexao();
		conexao = daoConexao.getConnection();
	}
	
	@Override
	public void InsereProduto(Produto produto) {
		try {
			String sql = "INSERT INTO produto (nome, marca, descricao, valor, quantidade) " +
					"VALUES ( ?, ?, ?, ?, ?)";
					PreparedStatement stmt = conexao.prepareStatement(sql);
					stmt.setString(1, produto.getNome());
					stmt.setString(2, produto.getMarca());
					stmt.setString(3, produto.getDescricao());
					stmt.setDouble(4, produto.getValor());
					stmt.setDouble(5, produto.getQuantidade());
					stmt.executeQuery();
					conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void RemoveProduto(Produto p) {
		
		
	}

	@Override
	public void PesquisaProduto(Produto p) {
		
		
	}

	
}
