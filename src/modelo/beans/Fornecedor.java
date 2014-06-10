package modelo.beans;

public class Fornecedor {
	
	public static final String STRING_VAZIO = "";
	
	private String cpf_cnpj;
	private String nome;
	private String uf;
	private String situacaoCadastral;
	
	
	public Fornecedor() {
		this.cpf_cnpj = STRING_VAZIO;
		this.nome = STRING_VAZIO;
		this.uf = STRING_VAZIO;
		this.situacaoCadastral = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Fornecedor))
			return false;
		
		Fornecedor outroFornecedor = (Fornecedor) object;
		return this.getCpf_cnpj().equals(outroFornecedor.getCpf_cnpj());
	}
	
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}
	
	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}

}
