package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.Party;
import model.dao.PartidoDAO;

public class PartidoControle {
	
	/*
	 * Control class political party, which mediates the application layer with the model
	 */
	
	// Attributes
	private PartidoDAO partidoDAO;
	
	// Constructors	
	public PartidoControle() {
		this.partidoDAO = new PartidoDAO();
	}
	
	// Other methods
	/*
	 * Method that requests a search of all political parties 
	 * @return an ArrayList with all political parties
	 */
	public ArrayList<Party> getListaTodosPartidos() throws SQLException {
		return this.partidoDAO.getLista();
	}
	
	/*
	 * Method that requests a search of all political parties with the abbreviation informed
	 * @param the abbreviation of the political party
	 * @return the political party with the abbreviation informed
	 */
	public Party getPelaSigla(String sigla) throws SQLException {
		return this.partidoDAO.getPelaSigla(sigla);
	}
	
	/*
	 * Method that requests a search of all political parties with the political number informed
	 * @param the political number of the political party
	 * @return the political party with the political number informed
	 */
	public Party getPeloNumero(String numero) throws SQLException {
		return this.partidoDAO.getPeloNumero(numero);
	}
}
