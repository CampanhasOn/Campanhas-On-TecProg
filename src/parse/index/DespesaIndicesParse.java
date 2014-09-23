package parse.index;

import model.beans.Expense;
import model.beans.Supplier;

public class DespesaIndicesParse extends MovimentacaoFinanceiraIndicesParse<Expense> {
	
	/*
	 * Class to control the contents of information inherent to the expenses
	 */

	// Attributes
	private int indiceFornecedorNome;
	private int indiceFornecedorCpfCnpj;
	private int indiceTipoDocumento;
	
	// Constructors
	public DespesaIndicesParse(String ano) {
		super(ano);
		this.indiceFornecedorNome = INDICE_INVALIDO;
		this.indiceFornecedorCpfCnpj = INDICE_INVALIDO;
		this.indiceTipoDocumento = INDICE_INVALIDO;
	}
	
	/*
	 * This method formalizes the indices for reading the information about the expenses in the file
	 * @param an instance of the Class Expense
	 * @param an array of strings
	 */
	@Override
	protected void setIndicesValidos(Expense expense, String[] campo) {
		super.setIndicesValidos(expense, campo);
		Supplier supplier = new Supplier();

		if(indiceValido(this.indiceFornecedorNome)) {
			supplier.setSupplierName(campo[this.indiceFornecedorNome]);
		}
		if(indiceValido(this.indiceFornecedorCpfCnpj)) {
			supplier.setSupplierPersonRegister(campo[this.indiceFornecedorCpfCnpj]);
		}
		if(indiceValido(this.indiceTipoDocumento)) {
			expense.setExpenseDocumentType(campo[this.indiceTipoDocumento]);
		}
		expense.setExpenseSupplier(supplier);

	}
	
	/*
	 * This method ensures the boot empty content for attributes
	 * @param an instance of Class Expense
	 */
	@Override
	protected void setVazioEmTodosOsSetters(Expense expense) {
		super.setVazioEmTodosOsSetters(expense);
		expense.setExpenseSupplier((Supplier)Expense.EMPTY_OBJECT);
		expense.setExpenseDocumentType(Expense.EMPTY_TYPE_STRING);
	}
	
	// Mutators for indexes of the array of fields
	public void setIndiceFornecedorNome(int indiceFornecedorNome) {
		this.indiceFornecedorNome = indiceFornecedorNome;
	}
	
	public void setIndiceFornecedorCpfCnpj(int indiceFornecedorCpfCnpj) {
		this.indiceFornecedorCpfCnpj = indiceFornecedorCpfCnpj;
	}

	public void setIndiceTipoDocumento(int indiceTipoDocumento) {
		this.indiceTipoDocumento = indiceTipoDocumento;
	}
	
}