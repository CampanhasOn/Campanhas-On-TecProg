package teste.modelo.bean;

import static teste.modelo.bean.BeanTeste.instanciarCampanha;
import static teste.modelo.bean.BeanTeste.instanciarCandidato;
import static teste.modelo.bean.BeanTeste.instanciarCargo;
import static teste.modelo.bean.BeanTeste.instanciarPartido;
import static teste.modelo.bean.BeanTeste.instanciarResultado;
import modelo.beans.Campaign;
import modelo.beans.Position;
import modelo.beans.Result;

import org.junit.Assert;
import org.junit.Test;

public class CampanhaTeste {
	
	@Test
	public void equalsDeveRetornarVerdadeiroSeForemCampanhasIguais() {
		
		Campaign campaign = instanciarCampanha();
		Campaign campanha2 = instanciarCampanha();
		Assert.assertTrue(campaign.equals(campanha2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemCampanhasDiferentes() {
		
		Campaign campaign = instanciarCampanha();
		Campaign campanha2 = instanciarCampanha();
		campanha2.setAno(BeanTeste.INT_TESTE_2);
		Assert.assertFalse(campaign.equals(campanha2));
		campanha2.setAno(BeanTeste.INT_TESTE);
		Position position = instanciarCargo();
		position.setDescricao(BeanTeste.STRING_TESTE_2);
		campanha2.setCampaignPosition(position);
		Assert.assertFalse(campaign.equals(campanha2));
		position.setDescricao(BeanTeste.STRING_TESTE);
		campanha2.setNomeDeUrna(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(campaign.equals(campanha2));
		campanha2.setNomeDeUrna(BeanTeste.STRING_TESTE);
		campanha2.setNumeroCandidato(BeanTeste.INT_TESTE_2);
		Assert.assertFalse(campaign.equals(campanha2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeNaoCompararComCampanha() {
		
		Campaign campaign = instanciarCampanha();
		Result result = instanciarResultado();
		
		Assert.assertFalse(campaign.equals(result));
		Assert.assertFalse(result.equals(campaign));
		Assert.assertEquals(result,campaign.getCampaignResult());
		Assert.assertEquals(BeanTeste.INT_TESTE,campaign.getId());
		Assert.assertEquals(instanciarPartido(),campaign.getCampaignParty());
		Assert.assertEquals(instanciarCandidato(),campaign.getCandidato());
		Assert.assertEquals(BeanTeste.STRING_TESTE,campaign.getUf());
		Assert.assertEquals(BeanTeste.FLOAT_TESTE,campaign.getDespesaMaxDeclarada(),0);
		Assert.assertEquals(BeanTeste.FLOAT_TESTE,campaign.getDespesaTotalCalculada(),0);
		Assert.assertEquals(BeanTeste.FLOAT_TESTE,campaign.getReceitaTotalCalculada(),0);
		Assert.assertEquals(BeanTeste.INT_TESTE,result.getCodigo());
	}
	
}
