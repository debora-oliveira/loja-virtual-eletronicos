package loja.virtual.model;

import java.util.Date;

public class Compra {
	private long id;
	private long idCliente;
	private double totalDaCompra;
	private Date data;
	private Date horario;
	//pagamento
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
