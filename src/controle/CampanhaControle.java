package controle;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.dao.CampanhaDAO;

public class CampanhaControle {
	
	private CampanhaDAO campanhaDAO;

	public CampanhaControle() {
		this.campanhaDAO = new CampanhaDAO();
	}
	
	public ArrayList<Campanha> getListaCampanhas(Candidato candidato) {
		return this.campanhaDAO.getCampanhas(candidato);
	}
	
	public ArrayList<Campanha> getListaCampanhasPorSiglaPartidoEAno(String sigla, String ano){
		return this.campanhaDAO.getCampanhasPorSiglaPartidoEAno(sigla,ano);
	}
}