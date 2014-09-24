package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import model.beans.Position;
import model.dao.PositionDAO;

import org.junit.Test;

import parse.ParseException;
import parse.register.campaign.CadastroCargoParse;
import teste.TemplateTeste;

public class CadastroCargoParseTeste extends TemplateTeste {

	private CadastroCargoParse cadastro;
	private PositionDAO positionDAO;
	String  tipoArquivo = "campanha";
	String  ano         = "2006";
	
	@Override
	public void beforeTest() throws Exception {
		
		this.cadastro = new CadastroCargoParse(this.tipoArquivo, this.ano);	
		this.positionDAO = new PositionDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void deveRetornarUmCandidatoCadastrado() throws ParseException, SQLException {
		
		String campo[] = new String[50];
		campo[8] = "1";
		campo[9] = "CARGO TESTE";
		cadastro.runFileLine(campo);
		cadastro.registerInstances();
		
		Position position = this.positionDAO.getPositionByCode(1);
		assertEquals(position.getPositionCode().toString(), "1");
	}

}
