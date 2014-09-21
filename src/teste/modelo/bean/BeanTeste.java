package teste.modelo.bean;

import modelo.beans.Campaign;
import modelo.beans.Candidate;
import modelo.beans.Position;
import modelo.beans.Expense;
import modelo.beans.Donor;
import modelo.beans.Fornecedor;
import modelo.beans.MovimentacaoFinanceira;
import modelo.beans.Partido;
import modelo.beans.Receita;
import modelo.beans.Resultado;

public class BeanTeste {
	
	BeanTeste() {}
	public void usarBeanTeste() {}
	
	public static final Integer INT_TESTE = 50;
	public static final Integer INT_TESTE_2 = 60;
	public static final float FLOAT_TESTE = 1000;
	public static final float FLOAT_TESTE_2 = 2000;
	public static final String STRING_TESTE = "String Teste";
	public static final String STRING_TESTE_2 = "String Teste Dois";
	
	public static Campaign instanciarCampanha() {
		
		Campaign campaign = new Campaign();
		campaign.setAno(INT_TESTE);
		campaign.setCandidato(instanciarCandidato());
		campaign.setCargo(instanciarCargo());
		campaign.setDespesaMaxDeclarada(FLOAT_TESTE);
		campaign.setDespesaTotalCalculada(FLOAT_TESTE);
		campaign.setId(INT_TESTE);
		campaign.setNomeDeUrna(STRING_TESTE); 
		campaign.setNumeroCandidato(INT_TESTE);
		campaign.setPartido(instanciarPartido());
		campaign.setReceitaTotalCalculada(FLOAT_TESTE);
		campaign.setResultado(instanciarResultado());
		campaign.setUf(STRING_TESTE);
		
		return campaign;
	}
	
	public static Candidate instanciarCandidato() {
		
		Candidate candidate = new Candidate();
		candidate.setNome(STRING_TESTE);
		candidate.setTituloEleitoral(STRING_TESTE);
		
		return candidate;
	}
	
	public static Position instanciarCargo() {
		
		Position position = new Position();
		position.setCodigo(INT_TESTE);
		position.setDescricao(STRING_TESTE);
		
		return position;
	}
	
	public static Expense instanciarDespesa() {
		
		Expense expense = new Expense();
		expense.setCampanha(instanciarCampanha());
		expense.setData(STRING_TESTE);
		expense.setDescricao(STRING_TESTE);
		expense.setFormaPagamento(STRING_TESTE);
		expense.setFornecedor(instanciarFornecedor());
		expense.setId(INT_TESTE);
		expense.setNumeroDocumento(STRING_TESTE);
		expense.setTipoDocumento(STRING_TESTE);
		expense.setTipoMovimentacao(STRING_TESTE);
		expense.setValor(FLOAT_TESTE);
		
		return expense;
	}
	
	public static Donor instanciarDoador() {
		
		Donor donor = new Donor();
		donor.setCpf_cnpj(STRING_TESTE);
		donor.setNome(STRING_TESTE);
		donor.setSituacaoCadastral(STRING_TESTE);
		donor.setUf(STRING_TESTE);
		
		return donor;		
	}
	
	public static Fornecedor instanciarFornecedor() {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCpf_cnpj(STRING_TESTE);
		fornecedor.setNome(STRING_TESTE);
		fornecedor.setSituacaoCadastral(STRING_TESTE);
		fornecedor.setUf(STRING_TESTE);
		
		return fornecedor;
	}
	
	public static MovimentacaoFinanceira instanciarMovimentacaoFinanceira() {
		
		MovimentacaoFinanceira movimentacaoFinanceira = new MovimentacaoFinanceira();
		movimentacaoFinanceira.setCampanha(instanciarCampanha());
		movimentacaoFinanceira.setData(STRING_TESTE);
		movimentacaoFinanceira.setDescricao(STRING_TESTE);
		movimentacaoFinanceira.setFormaPagamento(STRING_TESTE);
		movimentacaoFinanceira.setId(INT_TESTE);
		movimentacaoFinanceira.setNumeroDocumento(STRING_TESTE);
		movimentacaoFinanceira.setTipoMovimentacao(STRING_TESTE);
		movimentacaoFinanceira.setValor(FLOAT_TESTE);
		
		return movimentacaoFinanceira;
	}
	
	public static Partido instanciarPartido() {
		
		Partido partido = new Partido();
		partido.setDeferimento(STRING_TESTE);
		partido.setNome(STRING_TESTE);
		partido.setNumero(INT_TESTE);
		partido.setSigla(STRING_TESTE);
		
		return partido;
	}
	
	public static Receita instanciarReceita() {
		
		Receita receita = new Receita();
		receita.setCampanha(instanciarCampanha());
		receita.setData(STRING_TESTE);
		receita.setDescricao(STRING_TESTE);
		receita.setDoador(instanciarDoador());
		receita.setFormaPagamento(STRING_TESTE);
		receita.setId(INT_TESTE);
		receita.setNumeroDocumento(STRING_TESTE);
		receita.setReciboEleitoral(STRING_TESTE);
		receita.setTipoMovimentacao(STRING_TESTE);
		receita.setValor(FLOAT_TESTE);

		return receita;
	}
	
	public static Resultado instanciarResultado() {
		
		Resultado resultado = new Resultado();
		resultado.setCodigo(INT_TESTE);
		resultado.setDescricao(STRING_TESTE);
		
		return resultado;
	}
	
}
