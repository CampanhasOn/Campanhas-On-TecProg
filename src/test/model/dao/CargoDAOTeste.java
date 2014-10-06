package test.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.Position;
import model.dao.PositionDAO;

import org.junit.Assert;
import org.junit.Test;

import test.TemplateTest;

public class CargoDAOTeste extends TemplateTest {

	private PositionDAO positionDAO;

	@Override
	public void beforeTest() throws Exception {
		
		this.positionDAO = new PositionDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void deveRecuperarUmCargoPeloCodigo() throws SQLException {

		ArrayList<Position> listaCargos = new ArrayList<>();
		Position cargoRecuperado = new Position();

		Position c1 = new Position();
		c1.setPositionCode(1);
		c1.setPositionDescription("POSITION UM");
		listaCargos.add(c1);

		Position c2 = new Position();
		c2.setPositionCode(2);
		c2.setPositionDescription("POSITION DOIS");
		listaCargos.add(c2);

		this.positionDAO.registerUnregisteredObjectArrayListOnDatabase(listaCargos);

		cargoRecuperado = this.positionDAO.getPositionByCode(1);
		Assert.assertEquals(c1, cargoRecuperado);
	}
	
	@Test
	public void deveRecuperarUmCargoPelaDescricao() throws SQLException {

		ArrayList<Position> listaCargos = new ArrayList<>();
		Position cargoRecuperado = new Position();

		Position c1 = new Position();
		c1.setPositionCode(1);
		c1.setPositionDescription("POSITION UM");
		listaCargos.add(c1);

		Position c2 = new Position();
		c2.setPositionCode(2);
		c2.setPositionDescription("POSITION DOIS");
		listaCargos.add(c2);

		this.positionDAO.registerUnregisteredObjectArrayListOnDatabase(listaCargos);

		cargoRecuperado = this.positionDAO.getPositionByDescription("POSITION UM");
		Assert.assertEquals(c1, cargoRecuperado);
	}
	
	@Test
	public void deveRecuperarUmaListaDeCargos() throws SQLException {
		
		ArrayList<Position> listaCargos = new ArrayList<>();
		ArrayList<Position> listaRecuperada = new ArrayList<>();
		
		Position c1 = new Position();
		c1.setPositionCode(1);
		c1.setPositionDescription("POSITION UM");
		listaCargos.add(c1);

		Position c2 = new Position();
		c2.setPositionCode(2);
		c2.setPositionDescription("POSITION DOIS");
		listaCargos.add(c2);
		
		Position c3 = new Position();
		c3.setPositionCode(3);
		c3.setPositionDescription("POSITION TR�S");
		listaCargos.add(c3);
		
		this.positionDAO.registerUnregisteredObjectArrayListOnDatabase(listaCargos);
		listaRecuperada = this.positionDAO.getObjectArrayListFromDatabase();
		
		Assert.assertEquals(listaRecuperada, this.positionDAO.getObjectArrayListFromDatabase());
	}

	@Test
	public void valoresComparacao() throws Exception {

		Position c1 = new Position();
		Position c2 = new Position();
		c1.setPositionCode(1);
		c2.setPositionCode(2);
		int resultado;

		resultado = PositionDAO.CompareTwoPositionsCode.POSITION_CODE.compare(c1, c2);

		Assert.assertNotEquals(0, resultado);
	}

}
