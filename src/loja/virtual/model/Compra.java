package loja.virtual.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
	private int id;
	private int idCliente;
	private double totalDaCompra;
	private Date data;
	private Date horario;
	private List<Produto> itensCompra = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getTotalDaCompra() {
		return totalDaCompra;
	}
	public void setTotalDaCompra(double totalDaCompra) {
		this.totalDaCompra = totalDaCompra;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public List<Produto> getItensCompra() {
		return itensCompra;
	}
	public void setItensCompra(List<Produto> itensCompra) {
		this.itensCompra = itensCompra;
	}
}
