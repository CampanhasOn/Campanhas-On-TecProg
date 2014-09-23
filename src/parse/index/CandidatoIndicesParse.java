package parse.index;

import model.beans.Candidate;

public class CandidatoIndicesParse extends IndicesParse<Candidate> {
	
	/*
	 * Class to control the contents of information inherent to the candidates
	 */

	// Attributes
	private int indiceNome;
	private int indiceTituloEleitoral;

	// Constructors
	public CandidatoIndicesParse() {
		this.indiceNome = INDICE_INVALIDO;
		this.indiceTituloEleitoral = INDICE_INVALIDO;
	}

	/*
	 * This method formalizes the indices for reading the information about the candidates in the file
	 * @param an instance of Class Candidate
	 * @param an array of strings
	 */
	@Override
	protected void setIndicesValidos(Candidate candidate, String[] campo) {
		if (indiceValido(this.indiceNome)) {
			candidate.setCandidateName(campo[this.indiceNome]);
		}
		if (indiceValido(this.indiceTituloEleitoral)) {
			candidate.setCandidateElectoralTitle(campo[this.indiceTituloEleitoral]);

		}
	}

	/*
	 * This method ensures the boot empty content for attributes
	 * @param an instance of Class Candidate
	 */
	@Override
	protected void setVazioEmTodosOsSetters(Candidate candidate) {
		candidate.setCandidateName(Candidate.EMPTY_TYPE_STRING);
		candidate.setCandidateElectoralTitle(Candidate.EMPTY_TYPE_STRING);
	}

	// Mutators for indexes of the array of fields
	public void setIndiceTituloEleitoral(int indiceTituloEleitoral) {
		this.indiceTituloEleitoral = indiceTituloEleitoral;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

}