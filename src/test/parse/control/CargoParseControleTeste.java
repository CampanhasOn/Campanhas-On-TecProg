package test.parse.control;

import model.beans.Position;
import model.dao.PositionDAO;

import org.junit.Assert;
import org.junit.Test;

import parse.control.ParseControlPosition;
import parse.index.PositionParseIndex;
import test.TemplateTest;

public class CargoParseControleTeste extends TemplateTest {

	public static final int CODIGO = 0;
	public static final int DESCRICAO = 1;
	
	private String campo[];
	private PositionDAO positionDAO;
	private PositionParseIndex positionParseIndex;
	private ParseControlPosition parseControlPosition;

	@Override
	public void beforeTest() throws Exception {
		this.campo = new String[2];
		this.positionDAO = new PositionDAO();
		this.positionParseIndex = new PositionParseIndex();
		this.parseControlPosition = new ParseControlPosition(this.positionParseIndex);
		
		iniciarCampos();
		iniciarIndices();
	}
	
	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void cadastrarCargo() throws Exception {
		
		this.parseControlPosition.addInstance(campo);
		this.parseControlPosition.registeringInstances();
		this.parseControlPosition.clear();
		
		Position cargoCadastrado = this.positionDAO.getObjectArrayListFromDatabase().get(0);
				
		Assert.assertEquals(this.campo[CODIGO], cargoCadastrado.getPositionCode().toString());
		Assert.assertEquals(this.campo[DESCRICAO], cargoCadastrado.getPositionDescription());
	}
	
	@Test
	public void naoDeveCadastrarDoisCargosIguais() throws Exception {
		
		this.parseControlPosition.addInstance(campo);
		this.parseControlPosition.addInstance(campo);
		this.parseControlPosition.registeringInstances();
		this.parseControlPosition.clear();
		
		int numeroCargosCadastrados = this.positionDAO.getObjectArrayListFromDatabase().size();
		
		Assert.assertEquals(1, numeroCargosCadastrados);
	}
	
	private void iniciarIndices() {
		
		this.positionParseIndex.setIndexCode(CODIGO);
		this.positionParseIndex.setIndexDescription(DESCRICAO);
	}
	
	private void iniciarCampos() {
		
		this.campo[CODIGO] = "125";
		this.campo[DESCRICAO] = "CARGO INEXISTENTE";
	}

}