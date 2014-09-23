package parse.index;

import model.beans.Result;

public class ResultadoIndicesParse extends IndicesParse<Result> {
	
	/*
	 * Class to control the contents of information inherent to the results
	 */

	// Attributes
	private int indiceCodigo;
	private int indiceDescricao;
	
	// Constructors
	public ResultadoIndicesParse() {
		this.indiceCodigo = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
	}
	
	/*
	 * This method formalizes the indices for reading the information about the results in the file
	 * @param an instance of the Class Result
	 * @param an array of strings
	 */
	@Override
	protected void setIndicesValidos(Result result, String[] campo) {
		if (indiceValido(this.indiceCodigo)) {
			result.setResultType(Integer.parseInt(campo[this.indiceCodigo]));
		}
		if (indiceValido(this.indiceDescricao)) {
			result.setResultDescription(campo[this.indiceDescricao]);
		}	
	}

	/*
	 * This method ensures the boot empty content for attributes
	 * @param an instance of Class Result
	 */
	@Override
	protected void setVazioEmTodosOsSetters(Result result) {
		result.setResultType(Result.EMPTY_TYPE_INTEGER);
		result.setResultDescription(Result.EMPTY_TYPE_STRING);
	}

	// Mutators for indexes of the array of fields
	public void setIndiceCodigo(int indiceCodigo) {
		this.indiceCodigo = indiceCodigo;
	}

	public void setIndiceDescricao(int indiceDescricao) {
		this.indiceDescricao = indiceDescricao;
	}
	
}