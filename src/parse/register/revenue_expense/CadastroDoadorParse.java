package parse.register.revenue_expense;

import model.beans.Donor;
import parse.ParseException;
import parse.control.ParseControlDonor;
import parse.control.ParseControle;
import parse.index.DoadorIndicesParse;
import parse.index.IndicesParse;

public class CadastroDoadorParse extends CadastroParseReceitasDespesas<Donor> {

	public CadastroDoadorParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	public ParseControle<Donor> novaInstancia(IndicesParse<Donor> indicesParse) {
		ParseControlDonor parseControlDonor = new ParseControlDonor(indicesParse);
		return parseControlDonor;
	}
	
	public DoadorIndicesParse getIndicesParseReceita2002() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(6);
		doadorIndicesParse.setIndiceNome(8);
		doadorIndicesParse.setIndiceUf(7);
		
		return doadorIndicesParse;
	}
	
	public DoadorIndicesParse getIndicesParseReceita2006() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(16);
		doadorIndicesParse.setIndiceNome(15);
		doadorIndicesParse.setIndiceUf(17);
		doadorIndicesParse.setIndiceSituacaoCadastral(18);
		
		return doadorIndicesParse;
	}
	
	public DoadorIndicesParse getIndicesParseReceita2010() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(10);
		doadorIndicesParse.setIndiceNome(11);
		
		return doadorIndicesParse;
	}

	@Override
	protected IndicesParse<Donor> getIndicesParseDespesa2002() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Donor> getIndicesParseDespesa2006() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Donor> getIndicesParseDespesa2010() {
		return new DoadorIndicesParse();
	}

}