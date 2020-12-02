package loja.virtual.db;

import loja.virtual.model.Cliente;
import loja.virtual.model.User;

public interface InterfaceClienteDAO {
	public User validarLogin(String email, String senha);
	public void insereCliente(Cliente cliente);
	public void pesquisaCliente(Cliente cliente);
}
