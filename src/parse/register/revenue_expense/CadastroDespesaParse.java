package parse.register.revenue_expense;

import model.beans.Expense;
import parse.ParseException;
import parse.control.ParseControlExpense;
import parse.control.ParseControl;
import parse.index.ExpenseParseIndex;
import parse.index.ParseIndex;

public class CadastroDespesaParse extends CadastroParseReceitasDespesas<Expense> {
	
	/* 
	 * Class used to extract Expense attributes and forward the register to the Database
	 */
	
	// Constructor
	
	/*
	 * This constructor use the ParseExpenseRevenueRegister inherited constructor to
	 * register informations from an Expense
	 * @param String who define the type of the list file to be used to get the ParseIndex
	 * @param String who define the year of the campaign to be used to get the ParseIndex
	 */
	public CadastroDespesaParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}
	
	// Methods
	
	/*
	 * @see parse.register.CadastroParse#novaInstancia(parse.index.ParseIndex)
	 * This method generate a ParseExpenseControl to be used by constructor
	 * @return a ParseExpenseControl
	 */
	@Override
	public ParseControl<Expense> novaInstancia(
			ParseIndex<Expense> indicesParse) {
		return new ParseControlExpense(indicesParse);
	}

	/*
	 * @see parse.register.receita_despesa.CadastroParseReceitasDespesas#getIndicesParseDespesa2002()
	 * This method generate the ParseExpenseIndex, setting the index number for each attribute from
	 * the Campaign of 2002
	 * @return a ParseExpenseIndex
	 */
	@Override
	protected ParseIndex<Expense> getIndicesParseDespesa2002() {
		ExpenseParseIndex expenseParseIndex = new ExpenseParseIndex(YEAR_2002);
		expenseParseIndex.setIndexUnitFederationCampaign(0);
		expenseParseIndex.setIndexNumberCampaign(4);
		expenseParseIndex.setIndexPositionCampaign(2);
		expenseParseIndex.setIndexTypeOfFinancialTransaction(10);
		expenseParseIndex.setIndexDate(5);
		expenseParseIndex.setIndexCpfCnpjSupplier(6);
		expenseParseIndex.setIndexNameSupplier(8);
		expenseParseIndex.setIndexValue(9);	
		return expenseParseIndex;
	}

	/*
	 * @see parse.register.receita_despesa.CadastroParseReceitasDespesas#getIndicesParseDespesa2006()
	 * This method generate the ParseExpenseIndex, setting the index number for each attribute from
	 * the Campaign of 2006
	 * @return a ParseExpenseIndex
	 */
	@Override
	protected ParseIndex<Expense> getIndicesParseDespesa2006() {
		ExpenseParseIndex expenseParseIndex = new ExpenseParseIndex(YEAR_2006);
		expenseParseIndex.setIndexUnitFederationCampaign(4);
		expenseParseIndex.setIndexNumberCampaign(3);
		expenseParseIndex.setIndexPositionCampaign(1);
		expenseParseIndex.setIndexTypeOfFinancialTransaction(11);
		expenseParseIndex.setIndexDocumentType(16);
		expenseParseIndex.setIndexFormOfPayment(13);
		expenseParseIndex.setIndexDocumentNumber(15);
		expenseParseIndex.setIndexDate(10);
		expenseParseIndex.setIndexCpfCnpjSupplier(19);
		expenseParseIndex.setIndexCpfCnpjSupplier(18);
		expenseParseIndex.setIndexValue(9);	
		return expenseParseIndex;

	}

	/*
	 * @see parse.register.receita_despesa.CadastroParseReceitasDespesas#getIndicesParseDespesa2010()
	 * This method generate the ParseExpenseIndex, setting the index number for each attribute from
	 * the Campaign of 2010
	 * @return a ParseExpenseIndex
	 */
	@Override
	protected ParseIndex<Expense> getIndicesParseDespesa2010() {
		ExpenseParseIndex expenseParseIndex = new ExpenseParseIndex(YEAR_2010);
		expenseParseIndex.setIndexUnitFederationCampaign(1);
		expenseParseIndex.setIndexNumberCampaign(3);
		expenseParseIndex.setIndexPositionCampaign(4);
		expenseParseIndex.setIndexTypeOfFinancialTransaction(14);
		expenseParseIndex.setIndexDocumentType(8);
		expenseParseIndex.setIndexFormOfPayment(16);
		expenseParseIndex.setIndexDocumentNumber(9);
		expenseParseIndex.setIndexDate(12);
		expenseParseIndex.setIndexCpfCnpjSupplier(10);
		expenseParseIndex.setIndexNameSupplier(11);
		expenseParseIndex.setIndexValue(13);	
		expenseParseIndex.setIndexDescription(17);
		return expenseParseIndex;
	}

	/*
	 * @see parse.register.receita_despesa.CadastroParseReceitasDespesas#getIndicesParseReceita2002()
	 * This method generate the ParseExpenseIndex from the Campaign of 2002
	 * @return a ParseExpenseIndex
	 */
	@Override
	protected ParseIndex<Expense> getIndicesParseReceita2002() {
		return new ExpenseParseIndex(YEAR_2002);
	}

	/*
	 * @see parse.register.receita_despesa.CadastroParseReceitasDespesas#getIndicesParseReceita2006()
	 * This method generate the ParseExpenseIndex from the Campaign of 2006
	 * @return a ParseExpenseIndex
	 */
	@Override
	protected ParseIndex<Expense> getIndicesParseReceita2006() {
		return new ExpenseParseIndex(YEAR_2006);
	}

	/*
	 * @see parse.register.receita_despesa.CadastroParseReceitasDespesas#getIndicesParseReceita2010()
	 * This method generate the ParseExpenseIndex from the Campaign of 2010
	 * @return a ParseExpenseIndex
	 */
	@Override
	protected ParseIndex<Expense> getIndicesParseReceita2010() {
		return new ExpenseParseIndex(YEAR_2010);
	}

}
