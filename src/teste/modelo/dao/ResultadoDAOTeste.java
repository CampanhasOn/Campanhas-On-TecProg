package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.Result;
import model.dao.ResultadoDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class ResultadoDAOTeste extends TemplateTeste {

	private ResultadoDAO dao;
	
	@Override
	public void beforeTest() throws Exception {
		
		this.dao = new ResultadoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRecuperarUmResultadoPeloCodigo() throws SQLException {
		
		ArrayList<Result> lista = new ArrayList<>();
		
		Result r1 = new Result();
		r1.setCodigo(1);
		r1.setDescricao("Result 1");
		lista.add(r1);
		
		Result r2 = new Result();
		r2.setCodigo(2);
		r2.setDescricao("Result 2");
		lista.add(r2);
		
		this.dao.cadastrarLista(lista);
			
		Result r3 = new Result();
		r3 = this.dao.getPeloCod(1);
		Assert.assertEquals(r1, r3);
	}
	
	@Test
	public void naoDeveAcharResultado() throws SQLException {
		
		ArrayList<Result> lista = new ArrayList<>();
		
		Result r1 = new Result();
		r1.setCodigo(1);
		r1.setDescricao("Result 1");
		lista.add(r1);
		
		Result r2 = new Result();
		r2.setCodigo(2);
		r2.setDescricao("Result 2");
		lista.add(r2);
		
		this.dao.cadastrarLista(lista);
			
		Result r3 = new Result();
		r3 = this.dao.getPeloCod(5);
		Assert.assertNotEquals(r1, r3);
	}
	
	@Test
	public void valoresComparacao() throws Exception {
		
		Result r1 = new Result();
		Result r2 = new Result();
		r1.setCodigo(1);
		r2.setCodigo(2);
		int resultado;

		resultado = ResultadoDAO.Comparacao.CODIGO.compare(r1, r2);
		
		Assert.assertNotEquals(0,resultado);
	}

}
