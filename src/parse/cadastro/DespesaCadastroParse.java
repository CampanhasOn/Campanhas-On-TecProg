package parse.cadastro;

import parse.controle.DespesaParseControle;
import parse.indices.DespesaIndicesParse;

public class DespesaCadastroParse {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	public static final String ANO_2002 = "2002";
	public static final String ANO_2004 = "2004";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2008 = "2008";
	
	private int linhasLidas;

	private DespesaParseControle despesaParse;
	private DespesaIndicesParse despesaIndicesParse;
	
	public DespesaCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
		
		this.despesaIndicesParse = getCandidatoIndicesParse(tipoArquivo, ano);
		this.despesaParse = new DespesaParseControle(this.despesaIndicesParse);
	}
	
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		try {
			this.despesaParse.addInstancia(campo);
			this.linhasLidas++;

			if(this.linhasLidas >= 20000) {
				this.despesaParse.cadastrarInstancias();
				this.despesaParse.resetar();
				this.linhasLidas = 0;
			}

		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void finalizarCadastros() {
		try {
			this.despesaParse.cadastrarInstancias();
			this.despesaParse.resetar();
			this.linhasLidas = 0;
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	private DespesaIndicesParse getCandidatoIndicesParse(String tipoArquivo, String ano) {
		if(tipoArquivo.equals(DESPESA)) {
			switch (ano) {
			case ANO_2002:
				return getDespesaIndicesParse2002();
			case ANO_2004:
				return getDespesaIndicesParse2004();

			case ANO_2006:
				return getDespesaIndicesParse2006();

			case ANO_2008:
				return getDespesaIndicesParse2008();

			default:
				return null;
			}
		}
		return null;
	}
	
	private DespesaIndicesParse getDespesaIndicesParse2002() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2002);
		despesaIndicesParse.setIndiceFornecedor(8);
		despesaIndicesParse.setIndiceEmNomeDe(3);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(10);		

		return despesaIndicesParse;
	}
	
	private DespesaIndicesParse getDespesaIndicesParse2004() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2004);
		despesaIndicesParse.setIndiceFornecedor(18);
		despesaIndicesParse.setIndiceEmNomeDe(0);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(11);	
		despesaIndicesParse.setIndiceTipoDocumento(16);
		despesaIndicesParse.setIndiceEspecie(13);

		return despesaIndicesParse;
	}
	
	private DespesaIndicesParse getDespesaIndicesParse2006() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2006);
		despesaIndicesParse.setIndiceFornecedor(18);
		despesaIndicesParse.setIndiceEmNomeDe(0);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(11);	
		despesaIndicesParse.setIndiceTipoDocumento(16);
		despesaIndicesParse.setIndiceEspecie(13);

		return despesaIndicesParse;
	}
	
	private DespesaIndicesParse getDespesaIndicesParse2008() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2008);
		despesaIndicesParse.setIndiceFornecedor(22);
		despesaIndicesParse.setIndiceEmNomeDe(0);
		despesaIndicesParse.setIndiceValor(13);
		despesaIndicesParse.setIndiceTipo(11);	
		despesaIndicesParse.setIndiceTipoDocumento(20);
		despesaIndicesParse.setIndiceEspecie(17);
		despesaIndicesParse.setIndiceNumeroDocumento(19);

		return despesaIndicesParse;
	}
		
}
