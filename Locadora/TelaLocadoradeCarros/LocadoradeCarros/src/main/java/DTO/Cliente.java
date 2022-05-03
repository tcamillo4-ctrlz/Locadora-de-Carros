package DTO;

public class Cliente {

    // Atributos da Classe -> Características
	
    String nomecli;
    String idadecli;
    String cpf;
    String endereco;
    String total;

    // Métodos -> Ações
    
    public Cliente(String nomecli, String idadecli, String cpf, String endereco, String total) {
		this.nomecli = nomecli;
		this.idadecli = idadecli;
		this.cpf = cpf;
		this.endereco = endereco;
		this.total = total;
	}

	///////////////////////////////////////////
	public void setNomeCli(String nomecli) {
		this.nomecli = nomecli;
	}
	public String getNomeCli() {
		return nomecli;
	}
	///////////////////////////////////////////
	public void setIdadeCli(String idadecli) {
		this.idadecli = idadecli;
	}
	public String getIdadeCli() {
		return idadecli;
	}
	///////////////////////////////////////////
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getCPF() {
		return cpf;
	}
	///////////////////////////////////////////
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return endereco;
	}
	///////////////////////////////////////////
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal() {
		return total;
	}
    
}