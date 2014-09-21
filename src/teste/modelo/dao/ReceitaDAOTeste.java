package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campaign;
import modelo.beans.Position;
import modelo.beans.Doador;
import modelo.beans.Receita;
import modelo.dao.ReceitaDAO;

import org.junit.Test;

import teste.TemplateTeste;

public class ReceitaDAOTeste extends TemplateTeste {
	
	private ReceitaDAO receitaDAO;
	private Receita receita1;
	private Receita receita2;
	private Campaign campanha1;
	private Doador doador1;
	private Position cargo1;
	private Campaign campanha2;
	private Doador doador2;
	private Position cargo2;

	@Override
	public void beforeTest() throws Exception {
		
		this.receitaDAO = new ReceitaDAO();
		this.campanha1 = new Campaign();
		this.doador1 = new Doador();
		this.cargo1 = new Position();
		this.receita1 = new Receita();
		this.receita2 = new Receita();
		this.campanha2 = new Campaign();
		this.doador2 = new Doador();
		this.cargo2 = new Position();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRecuperarUmaListaDeReceitas() throws SQLException {
		
		ArrayList<Receita> listaReceitas = new ArrayList<>();
		
		this.cargo1.setDescricao("CARGO UM");
		this.campanha1.setId(1);
		this.campanha1.setAno(2006);
		this.campanha1.setNumeroCandidato(45555);
		this.campanha1.setCargo(cargo1);
		this.doador1.setNome("DOADOR UM");
		this.doador1.setCpf_cnpj("55325424149");
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
		
		this.cargo2.setDescricao("CARGO DOIS");
		this.campanha2.setId(2);
		this.campanha2.setAno(2006);
		this.campanha2.setNumeroCandidato(131222);
		this.campanha2.setCargo(cargo2);
		this.doador2.setNome("DOADOR DOIS");
		this.doador2.setCpf_cnpj("55325424149");
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
