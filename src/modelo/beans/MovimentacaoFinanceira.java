package modelo.beans;


public class MovimentacaoFinanceira {
	
	public static final String STRING_VAZIO = "";
	public static final Integer INTEGER_VAZIO = 0;
	public static final Float FLOAT_VAZIO = (float) 0;
	public static final Object OBJETO_VAZIO = null;
	
	private Integer id;
	private Campanha campanha;
	private String numeroDocumento;
	private String data;
	private Float valor;
	private String tipoMovimentacao;
	private String formaPagamento;
	private String descricao;

	public MovimentacaoFinanceira(){
		this.id = INTEGER_VAZIO;
		this.campanha = (Campanha) OBJETO_VAZIO;
		this.numeroDocumento = STRING_VAZIO;
		this.data = STRING_VAZIO;
		this.valor = FLOAT_VAZIO;
		this.descricao = STRING_VAZIO;
		this.tipoMovimentacao = STRING_VAZIO;
		this.formaPagamento = STRING_VAZIO;
	}

	@Override
	public boolean equals(Object object) {
		return false;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}