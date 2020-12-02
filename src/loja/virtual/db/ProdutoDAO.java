package loja.virtual.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
			String sql = "INSERT INTO produto (nome, marca, descricao, valor, quantidade) " + "VALUES ( ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getDescricao());
			stmt.setDouble(4, produto.getValor());
			stmt.setInt(5, produto.getQuantidade());
			stmt.executeUpdate();
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
	public List<Produto> PesquisaTodosProdutos() {
		List<Produto> listaProdutos = new LinkedList<Produto>();

		try {
			String sql = "SELECT * FROM produto";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setMarca(rs.getString("marca"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));

				listaProdutos.add(produto);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro de SQL");
			System.out.println(e);
		}
		return listaProdutos;

	}

	@Override
	public List<Produto> PesquisaProduto(String nome) {
		List<Produto> listaProdutos = new LinkedList<Produto>();

		try {
			String sql = "select * from produto where nome like ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, '%' + nome + '%');
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setMarca(rs.getString("marca"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));

				listaProdutos.add(produto);
			}
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro de SQL");
			System.out.println(e);
		}
		return listaProdutos;
	}

}
