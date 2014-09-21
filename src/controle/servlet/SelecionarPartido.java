package controle.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Party;
import controle.PartidoControle;

public class SelecionarPartido implements Logica {
	
	/*
	 * Servlet requests to control the selection of political parties
	 */

	// Attributes
	private final int[] ANOS = {2010, 2006, 2002};
	private PartidoControle partidoControle;
	private Party party;

	private String sigla;
	private String siglaComUnder;
	private String linkTSE;

	// Other methods
	/*
	 * Concretizing  method that implements requests for the selection of one of the
	 * political parties in accordance with its logo and other information
	 * @param an HTTP request and HTTP response
	 * @return the next HTML page and their responses to requests
	 */
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.party = new Party();
		this.partidoControle = new PartidoControle();

		this.sigla = req.getParameter("sigla");
		this.siglaComUnder = this.sigla.replaceAll(" ", "_");
		this.siglaComUnder = this.siglaComUnder.toLowerCase();

		this.party = this.partidoControle.getPelaSigla(this.sigla);
		this.linkTSE = trocaDeCaracteresEspeciais(this.party);

		// Set of answers to requests made concerning the applicant requested
		req.setAttribute("party", this.party);
		req.setAttribute("anos", this.ANOS);
		req.setAttribute("linktse", this.linkTSE);
		req.setAttribute("siglaUnder", this.siglaComUnder);

		// Return the HTML page with the requested information
		return "/visualizar_partido.jsp";
	}
	
	/*
	 * Method for exchanging special characters emanating from the database, if any
	 * @param a political parties
	 * @return a String with exchanges
	 */
	private String trocaDeCaracteresEspeciais(Party party) {
		String local = party.getNome().toLowerCase();
		local = local.replaceAll(" ", "-");
		local = local.replaceAll("á", "a");
		local = local.replaceAll("ã", "a");
		local = local.replaceAll("ó", "o");
		local = local.replaceAll("ú", "u");
		local = local.replaceAll("ç", "c");
		return local;
	}
}
