package loja.virtual.db;

import java.util.List;

import loja.virtual.model.Cliente;
import loja.virtual.model.User;

public interface InterfaceClienteDAO {
	public User validarLogin(String email, String senha);
	public void insereCliente(Cliente cliente);
	public List<Cliente> pesquisaTodosClientes();
//	public List<Cliente> pesquisaCliente(String nome);
}
