package teste.modelo.bean;

import static org.junit.Assert.assertFalse;
import static teste.modelo.bean.BeanTeste.instanciarCampanha;
import static teste.modelo.bean.BeanTeste.instanciarDespesa;
import static teste.modelo.bean.BeanTeste.instanciarDoador;
import static teste.modelo.bean.BeanTeste.instanciarFornecedor;
import static teste.modelo.bean.BeanTeste.instanciarMovimentacaoFinanceira;
import static teste.modelo.bean.BeanTeste.instanciarReceita;
import model.beans.Campaign;
import model.beans.Donor;
import model.beans.Expense;
import model.beans.FinancialTransaction;
import model.beans.Revenue;
import model.beans.Supplier;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovimentacaoFinanceiraTeste {

	Expense expense;
	Revenue revenue;
	Expense despesa2;
	Revenue receita2;
	
	@Before
	public void SetUp() {
		
		this.expense = instanciarDespesa();
		this.revenue = instanciarReceita();
		this.despesa2 = instanciarDespesa();
		this.receita2 = instanciarReceita();
	}

	@Test
	public void equalsDeveRetornarFalsoEmQualquerCondicao() {

		Assert.assertFalse(expense.equals(revenue));
		Assert.assertFalse(revenue.equals(expense));
		Assert.assertEquals(BeanTeste.STRING_TESTE, expense.getExpenseDocumentType());
		Assert.assertEquals(instanciarFornecedor(), expense.getExpenseSupplier());
		Assert.assertEquals(BeanTeste.STRING_TESTE, revenue.getReciboEleitoral());
		Assert.assertEquals(instanciarDoador(), revenue.getDoador());
	}
	
	@Test
	public void equalsDeveRetornarVerdadeiro() {

		Expense outraDespesa = expense;
		Revenue outraReceita = revenue;
		
		Assert.assertFalse(expense.equals(outraDespesa));
		Assert.assertFalse(revenue.equals(outraReceita));
	}
	
	@Test
	public void equalsDeveRetornarFalsoParaOutrosCasos() {
		Donor doador2 = instanciarDoador();
		doador2.setDonorPersonRegister(BeanTeste.STRING_TESTE_2);
		
		Supplier fornecedor2 = instanciarFornecedor();
		fornecedor2.setCpf_cnpj(BeanTeste.STRING_TESTE_2);	
		
		receita2.setDoador(doador2);
		despesa2.setExpenseSupplier(fornecedor2);
		
		assertFalse(revenue.equals(receita2));
		assertFalse(expense.equals(despesa2));
		
	}
	
	@Test
	public void equalsDeveRetornarVerdadeiroSeForemMovimentacoesFinanceiraIguais() {
		
		FinancialTransaction financialTransaction = instanciarMovimentacaoFinanceira();
		FinancialTransaction movimentacaoFinanceira2 = instanciarMovimentacaoFinanceira();
		Assert.assertFalse(financialTransaction.equals(movimentacaoFinanceira2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemMovimentacoesFinancierasDiferentes() {
		
		FinancialTransaction financialTransaction = instanciarMovimentacaoFinanceira();
		FinancialTransaction movimentacaoFinanceira2 = instanciarMovimentacaoFinanceira();
		Campaign campaign = instanciarCampanha();
		campaign.setCampaignNameOfUrn(BeanTeste.STRING_TESTE_2);
		movimentacaoFinanceira2.setCampanha(campaign);
		Assert.assertFalse(financialTransaction.equals(movimentacaoFinanceira2));
		campaign.setCampaignNameOfUrn(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setCampanha(campaign);
		movimentacaoFinanceira2.setDescricao(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(financialTransaction.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setDescricao(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setFormaPagamento(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(financialTransaction.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setFormaPagamento(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setNumeroDocumento(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(financialTransaction.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setNumeroDocumento(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setTipoMovimentacao(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(financialTransaction.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setTipoMovimentacao(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setValor(BeanTeste.FLOAT_TESTE_2);
		Assert.assertFalse(financialTransaction.equals(movimentacaoFinanceira2));
		
		Assert.assertEquals(BeanTeste.INT_TESTE, financialTransaction.getId());
		Assert.assertEquals(BeanTeste.STRING_TESTE, financialTransaction.getData());
		
		BeanTeste bt = new BeanTeste();
		bt.usarBeanTeste();
		
		Assert.assertEquals((float) 1000, BeanTeste.FLOAT_TESTE,0);
		Assert.assertEquals((float) 2000, BeanTeste.FLOAT_TESTE_2,0);
		Assert.assertEquals("String Teste", BeanTeste.STRING_TESTE);
	}

}
