package loja.virtual.model;

import java.util.Date;

public class Pagamento {
	private Date dataPagamento;
	private double totalComDesconto;
	private String status;
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public double getTotalComDesconto() {
		return totalComDesconto;
	}
	public void setTotalComDesconto(double totalComDesconto) {
		this.totalComDesconto = totalComDesconto;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
