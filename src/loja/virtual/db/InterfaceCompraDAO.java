package loja.virtual.db;

import java.util.Date;
import java.util.List;

import loja.virtual.model.Compra;

public interface InterfaceCompraDAO {
	public void insereCompra(Compra compra);
	public List<Compra> pesquisaCompra(Date data);
	public void remove(int id);
}
