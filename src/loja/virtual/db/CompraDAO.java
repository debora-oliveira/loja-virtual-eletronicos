package loja.virtual.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.virtual.model.Compra;

public class CompraDAO implements InterfaceCompraDAO{
	
	@Autowired
	private Connection conexao;
	
	public CompraDAO() throws ClassNotFoundException, SQLException {
		GenericDAOConexao daoConexao = new GenericDAOConexao();
		conexao = daoConexao.getConnection();
	}

	@Override
	public void insereCompra(Compra compra) {
		try {
			String sql = "INSERT INTO compra (id, idCliente,totalDaCompra,data,horario,itensCompra) "+"VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, compra.getId());
			ps.setInt(2, compra.getIdCliente());
			ps.setDouble(3, compra.getTotalDaCompra());
			ps.setDate(4, (java.sql.Date) compra.getData());
			ps.setTime(5, (Time) compra.getHorario());
			ps.setObject(6, compra.getItensCompra());
			ps.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Compra> pesquisaCompra(Date data) {
		// para pesquisar registros de compras ja realizados, obtendo assim um historico das compras
		return null;
	}

	@Override
	public void remove(int id) {
		try {
			String sql = "DELETE FROM compra WHERE id=?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("ERRO de SQL");
		}
		
	}

}
