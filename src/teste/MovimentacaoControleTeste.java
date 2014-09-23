package teste;

import java.util.ArrayList;

import model.beans.Campaign;
import model.beans.Candidate;
import model.beans.Donor;
import model.beans.Expense;
import model.beans.Position;
import model.beans.Revenue;
import model.beans.Supplier;
import model.dao.ExpenseDAO;
import model.dao.RevenueDAO;

import org.junit.Assert;
import org.junit.Test;

import control.TransactionControl;

public class MovimentacaoControleTeste extends TemplateTeste {

	private ExpenseDAO expenseDAO;
	private RevenueDAO revenueDAO;
	private TransactionControl transactionControl;
	private Candidate candidate;
	private Campaign campaign;
	private Position position;
	private Revenue revenue;
	private Expense expense;
	private Donor donor;
	private Supplier supplier;
	private Integer ano;
	private String uf;
	private Integer numeroCandidato;

	@Override
	public void beforeTest() throws Exception {
		
		this.expenseDAO = new ExpenseDAO();
		this.revenueDAO = new RevenueDAO();
		this.transactionControl = new TransactionControl();
		this.candidate = new Candidate();
		this.campaign = new Campaign();
		this.revenue = new Revenue();
		this.expense = new Expense();
		this.donor = new Donor();
		this.supplier = new Supplier();
		this.ano = 2014;
		this.uf = "DF";
		this.position = new Position();
		this.numeroCandidato = 1234;
		
		ArrayList<Expense> listaDespesa = new ArrayList<>();
		ArrayList<Revenue> listaReceita = new ArrayList<>();

		candidate.setCandidateName("FULANO");
		candidate.setCandidateElectoralTitle("12345");
		
		position.setPositionDescription("Presidente");
		
		campaign.setCampaignPosition(position);
		campaign.setCampaignCandidate(candidate);
		campaign.setCampaignYear(this.ano);
		campaign.setCampaignCountryState(this.uf);
		campaign.setCampaignCandidateNumber(this.numeroCandidato);
		
		supplier.setSupplierPersonRegister("555555555555");
		donor.setDonorPersonRegister("333333333333");
		
		revenue.setFinancialTransactionPrice((float) 55.0);
		revenue.setFinancialTransactionCampaign(campaign);
		revenue.setFinancialTransactionIdentifier(3);
		revenue.setRevenueDonor(donor);
		listaReceita.add(revenue);
		
		expense.setFinancialTransactionPrice((float) 90.0);
		expense.setFinancialTransactionCampaign(campaign);
		expense.setFinancialTransactionIdentifier(5);
		expense.setExpenseSupplier(supplier);
		listaDespesa.add(expense);
		
		this.expenseDAO.registerUnregisteredObjectArrayListOnDatabase(listaDespesa);
		this.revenueDAO.registerUnregisteredObjectArrayListOnDatabase(listaReceita);
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRetornarUmaMovimentacaoPeloId() throws Exception {
		
		Assert.assertEquals(this.revenueDAO.getRevenueByIdentifier(3).getFinancialTransactionPrice(), this.transactionControl.getReceitaPeloId(3).getFinancialTransactionPrice());
		Assert.assertEquals(this.expenseDAO.getExpenseByIdentifier(5).getFinancialTransactionPrice(), this.transactionControl.getDespesaPeloId(5).getFinancialTransactionPrice());
	}
	
	
	@Test
	public void deveRecuperarMovimentacoesDeUmaCampanha() throws Exception {
		
		Campaign campanhaTeste = new Campaign();
		Assert.assertNull(this.transactionControl.getListaDespesas(campanhaTeste));
		Assert.assertNull(this.transactionControl.getListaReceitas(campanhaTeste));

		campanhaTeste.setCampaignPosition(this.position);
		Assert.assertNull(this.transactionControl.getListaDespesas(campanhaTeste));
		Assert.assertNull(this.transactionControl.getListaReceitas(campanhaTeste));
		
		campanhaTeste.setCampaignYear(this.ano);
		Assert.assertNull(this.transactionControl.getListaDespesas(campanhaTeste));
		Assert.assertNull(this.transactionControl.getListaReceitas(campanhaTeste));
	
		campanhaTeste.setCampaignCandidateNumber(this.numeroCandidato);
		Assert.assertNull(this.transactionControl.getListaDespesas(campanhaTeste));
		Assert.assertNull(this.transactionControl.getListaReceitas(campanhaTeste));
		
		campanhaTeste.setCampaignCountryState(this.uf);
		Assert.assertEquals(this.expenseDAO.getExpenseByCampaignYearAndCandidateNumberAndCampaignCountryStateAndCampaignPosition(campanhaTeste).size(),this.transactionControl.getListaDespesas(campanhaTeste).size());
		Assert.assertEquals(this.revenueDAO.getRevenueByCampaignPositionAndCampaignCountryStateAndCampaignYear(campanhaTeste).size(),this.transactionControl.getListaReceitas(campanhaTeste).size());
	}

}
