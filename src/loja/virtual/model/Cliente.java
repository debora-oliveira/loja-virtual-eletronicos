package loja.virtual.model;

public class Cliente  extends User{
	private long id;
	private String nome;
	private String cpf;
	private String telefone;
<<<<<<< HEAD

=======
	private List<Endereco> endereco = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
>>>>>>> branch 'main' of https://github.com/debora-oliveira/loja-virtual-eletronicos.git
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
