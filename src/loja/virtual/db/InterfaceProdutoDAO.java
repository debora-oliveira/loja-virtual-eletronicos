package loja.virtual.db;

import loja.virtual.model.Produto;

public interface InterfaceProdutoDAO {
	public void InsereProduto(Produto produto);
	public void RemoveProduto(Produto produto);
	public void PesquisaProduto(Produto produto);
}
