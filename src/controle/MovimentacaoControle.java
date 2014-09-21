package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Campaign;
import modelo.beans.Despesa;
import modelo.beans.Receita;
import modelo.dao.DespesaDAO;
import modelo.dao.ReceitaDAO;

public class MovimentacaoControle {
	
	/*
	 * Control class handling financial, which mediates the application layer with the model
	 */

	// Attributes
	DespesaDAO despesaDAO;
	ReceitaDAO receitaDAO;
	
	// Constructors
	public MovimentacaoControle(){
		this.despesaDAO = new DespesaDAO();
		this.receitaDAO = new ReceitaDAO();
	}

	// Other methods
	/*
	 * Method that makes the application of a revenue requirement of a campaign 
	 * @param a campaign
	 * @return a List with revenues campaign informed
	 */
	public List<Receita> getListaReceitas(Campaign campaign) throws Exception {

		ArrayList<Receita> listaReceita = new ArrayList<>();
		
		if((campaign.getCargo().getDescricao().equals(Campaign.STRING_VAZIO)) 
				|| (campaign.getAno().equals(Campaign.INTEGER_VAZIO)) 
				|| (campaign.getNumeroCandidato()).equals(Campaign.INTEGER_VAZIO)
				|| (campaign.getUf()).equals(Campaign.STRING_VAZIO)) {
			listaReceita =  null;
			
		} else {
			listaReceita = this.receitaDAO.getPorAnoNumeroCargoUf(campaign);
			
			if(campaign.getAno() == 2002) {
				for(Receita receita : listaReceita)
					receita.setTipoMovimentacao("Receita");
			}
		}
		return listaReceita;
	}

	/*
	 * Method that makes the request for an application of a campaign expense 
	 * @param a campaign
	 * @return a List with expenses campaign informed
	 */
	public List<Despesa> getListaDespesas(Campaign campaign) throws Exception {
		
		ArrayList<Despesa> listaDespesa = new ArrayList<>();
		
		if((campaign.getCargo().getDescricao().equals(Campaign.STRING_VAZIO)) 
				|| (campaign.getAno().equals(Campaign.INTEGER_VAZIO)) 
				|| (campaign.getNumeroCandidato()).equals(Campaign.INTEGER_VAZIO)
				|| (campaign.getUf()).equals(Campaign.STRING_VAZIO)) {
			listaDespesa =  null;
		} else {
			listaDespesa =  this.despesaDAO.getPorAnoNumeroCargoUf(campaign);
		}
		return listaDespesa;
	}

	/*
	 * Method that makes a request of request for a recipe campaign by ID
	 * @param a ID
	 * @return the reported income
	 */
	public Receita getReceitaPeloId(int id) throws Exception {
		return this.receitaDAO.getPeloId(id);
	}

	/*
	 * Method that makes a request of request for an expenditure campaign by ID 
	 * @param a ID
	 * @return the reported expense
	 */
	public Despesa getDespesaPeloId(int id) throws Exception {
		return this.despesaDAO.getPeloId(id);
	}
}
