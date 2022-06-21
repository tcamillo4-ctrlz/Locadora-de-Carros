package DTO;

public class Funcionario {
    
    // Atributos da Classe -> Características
	
    String nomefunc;
    String idadefunc;
    String cargo;
    String salario;

    // Métodos -> Ações
    
    public Funcionario(String nomefunc, String idadefunc, String cargo, String salario) {
		this.nomefunc = nomefunc;
		this.idadefunc = idadefunc;
		this.cargo = cargo;
		this.salario = salario;
	}

	///////////////////////////////////////////
	public void setNomeFunc(String nomefunc) {
		this.nomefunc = nomefunc;
	}
	public String getNomeFunc() {
		return nomefunc;
	}
	///////////////////////////////////////////
	public void setIdadeFunc(String idadefunc) {
		this.idadefunc = idadefunc;
	}
	public String getIdadeFunc() {
		return idadefunc;
	}
	///////////////////////////////////////////
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCargo() {
		return cargo;
	}
	///////////////////////////////////////////
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getSalario() {
		return salario;
	}

}
