package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.Campaign;
import model.beans.Donor;
import model.beans.Position;
import model.beans.Revenue;
import model.dao.ReceitaDAO;

import org.junit.Test;

import teste.TemplateTeste;

public class ReceitaDAOTeste extends TemplateTeste {
	
	private ReceitaDAO receitaDAO;
	private Revenue receita1;
	private Revenue receita2;
	private Campaign campanha1;
	private Donor doador1;
	private Position cargo1;
	private Campaign campanha2;
	private Donor doador2;
	private Position cargo2;

	@Override
	public void beforeTest() throws Exception {
		
		this.receitaDAO = new ReceitaDAO();
		this.campanha1 = new Campaign();
		this.doador1 = new Donor();
		this.cargo1 = new Position();
		this.receita1 = new Revenue();
		this.receita2 = new Revenue();
		this.campanha2 = new Campaign();
		this.doador2 = new Donor();
		this.cargo2 = new Position();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRecuperarUmaListaDeReceitas() throws SQLException {
		
		ArrayList<Revenue> listaReceitas = new ArrayList<>();
		
		this.cargo1.setPositionDescription("CARGO UM");
		this.campanha1.setCampaignIdentifier(1);
		this.campanha1.setCampaignYear(2006);
		this.campanha1.setCampaignCandidateNumber(45555);
		this.campanha1.setCampaignPosition(cargo1);
		this.doador1.setDonorName("DOADOR UM");
		this.doador1.setDonorPersonRegister("55325424149");
		receita1.setCampanha(campanha1);
		receita1.setValor((float) 450000.0);
		receita1.setFormaPagamento("FORMA PAGAMENTO UM");
		receita1.setDescricao("DESCRICAO UM");
		receita1.setData("12/10/2006");
		receita1.setTipoMovimentacao("TIPO MOVIMENTACAO UM");
		receita1.setReciboEleitoral("RECIBO ELEITORAL UM");
		receita1.setNumeroDocumento("NUMERO DOCUMENTO UM");
		receita1.setDoador(doador1);
		listaReceitas.add(receita1);
		
		this.cargo2.setPositionDescription("CARGO DOIS");
		this.campanha2.setCampaignIdentifier(2);
		this.campanha2.setCampaignYear(2006);
		this.campanha2.setCampaignCandidateNumber(131222);
		this.campanha2.setCampaignPosition(cargo2);
		this.doador2.setDonorName("DOADOR DOIS");
		this.doador2.setDonorPersonRegister("55325424149");
		receita2.setCampanha(campanha2);
		receita2.setValor((float) 500000.0);
		receita2.setFormaPagamento("FORMA PAGAMENTO DOIS");
		receita2.setDescricao("DESCRICAO DOIS");
		receita2.setData("12/10/2006");
		receita2.setTipoMovimentacao("TIPO MOVIMENTACAO DOIS");
		receita2.setReciboEleitoral("RECIBO ELEITORAL DOIS");
		receita2.setNumeroDocumento("NUMERO DOCUMENTO DOIS");
		receita2.setDoador(doador2);
		listaReceitas.add(receita2);
		
		this.receitaDAO.cadastrarLista(listaReceitas);
		this.receitaDAO.getLista();
	}

}
