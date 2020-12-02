package loja.virtual.db;

import java.util.List;

import loja.virtual.model.Produto;

public interface InterfaceProdutoDAO {
	public void InsereProduto(Produto produto);
	public void RemoveProduto(Produto produto);
	public List<Produto> PesquisaProduto(String nome);
	public List<Produto> PesquisaTodosProdutos();
}
