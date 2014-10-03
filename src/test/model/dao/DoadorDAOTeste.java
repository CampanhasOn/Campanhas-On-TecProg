package test.model.dao;

import java.util.ArrayList;

import model.beans.Donor;
import model.dao.DonorDAO;

import org.junit.Assert;
import org.junit.Test;

import test.TemplateTest;

public class DoadorDAOTeste extends TemplateTest {

	private DonorDAO donorDAO;
	
	@Override
	public void beforeTest() throws Exception {
		
		this.donorDAO = new DonorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void valoresComparacaoParteI() throws Exception {
		
		Donor D1 = new Donor();
		Donor D2 = new Donor();
		D1.setDonorPersonRegister("1234567");
		D2.setDonorPersonRegister("1234567");
		int resultado;

		resultado = DonorDAO.CompareTwoDonorsPersonRegister.NOME.compare(D1, D2);
		
		Assert.assertEquals(0,resultado);
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmDoadorInexistente() throws Exception {
		
		ArrayList<Donor> listaDoadores = new ArrayList<>();
		
		Donor donor = new Donor();
		donor.setDonorName("Nome");
		listaDoadores.add(donor);
		
		this.donorDAO.registerUnregisteredObjectArrayListOnDatabase(listaDoadores);
	}
	
	@Test
	public void naoDeveCadastrarUmDoadorJaExistente() throws Exception {
		
		ArrayList<Donor> listaDoadores = new ArrayList<>();
		
		Donor donor = new Donor();
		donor.setDonorName("Nome");
		listaDoadores.add(donor);

		this.donorDAO.registerUnregisteredObjectArrayListOnDatabase(listaDoadores);
		this.donorDAO.registerUnregisteredObjectArrayListOnDatabase(listaDoadores);
		
		Assert.assertEquals(1, this.donorDAO.getObjectArrayListFromDatabase().size());
	}
	
	@Test
	public void deveRecuperarUmaListaComOsDoadoresCadastrados() throws Exception {
		
		ArrayList<Donor> listaDoadores = new ArrayList<>();
		
		Donor donor = new Donor();
		donor.setDonorName("Nome");
		donor.setDonorPersonRegister("123");
		donor.setDonorRegisterSituation("Cadastrado");
		donor.setDonorCountryState("DF");
		listaDoadores.add(donor);
		
		donor = new Donor();
		donor.setDonorName("Nome2");
		donor.setDonorPersonRegister("1234");
		donor.setDonorRegisterSituation("Cadastrado");
		donor.setDonorCountryState("DF");
		listaDoadores.add(donor);

		this.donorDAO.registerUnregisteredObjectArrayListOnDatabase(listaDoadores);
		Assert.assertEquals(listaDoadores, this.donorDAO.getObjectArrayListFromDatabase());
	}
	
	@Test
	public void deveRecuperarUmDoadorPeloNomeOuCpfCnpj() throws Exception {
		
		ArrayList<Donor> listaDoadoresACadastrar = new ArrayList<>();
		Donor doadorRecuperado;
		
		Donor doador1 = new Donor();
		doador1.setDonorName("nome");
		doador1.setDonorPersonRegister("123456");
		doador1.setDonorRegisterSituation("REGULAR");
		doador1.setDonorCountryState("DF");
		listaDoadoresACadastrar.add(doador1);
		
		Donor doador2 = new Donor();
		doador2.setDonorName("nome2");
		doador2.setDonorPersonRegister("12345678");
		doador2.setDonorRegisterSituation("IRREGULAR");
		doador2.setDonorCountryState("DF");
		listaDoadoresACadastrar.add(doador2);
		
		this.donorDAO.registerUnregisteredObjectArrayListOnDatabase(listaDoadoresACadastrar);
		doadorRecuperado = this.donorDAO.getDonorByNameAndPersonRegister(doador1);
		
		Assert.assertEquals(doador1, doadorRecuperado);
	}
	
}