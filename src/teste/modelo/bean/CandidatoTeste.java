package teste.modelo.bean;

import static teste.modelo.bean.BeanTeste.instanciarCandidato;
import static teste.modelo.bean.BeanTeste.instanciarPartido;
import model.beans.Candidate;
import model.beans.Party;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTeste {

	@Test
	public void equalsDeveRetornarVerdadeiroSeForemCandidatosIguais() {
		
		Candidate candidate = instanciarCandidato();
		Candidate candidato2 = instanciarCandidato();
		Assert.assertTrue(candidate.equals(candidato2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemCandidatosDiferentes() {
		
		Candidate candidate = instanciarCandidato();
		Candidate candidato2 = instanciarCandidato();
		candidato2.setCandidateElectoralTitle(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(candidate.equals(candidato2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeNaoCompararComCandidato() {
		
		Candidate candidate = instanciarCandidato();
		Party party = instanciarPartido();
		Assert.assertFalse(candidate.equals(party));
		Assert.assertFalse(party.equals(candidate));
		
		Assert.assertEquals(BeanTeste.STRING_TESTE,candidate.getCandidateName());
		
		Assert.assertEquals(BeanTeste.STRING_TESTE,party.getSigla());
		Assert.assertEquals(BeanTeste.STRING_TESTE,party.getDeferimento());
		Assert.assertEquals(BeanTeste.STRING_TESTE,party.getNome());
	}

}
