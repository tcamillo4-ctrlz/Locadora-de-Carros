package modal;

public class FuncionarioDTO {
    
    // Atributos da Classe -> Características
	
	private Integer id_funcionario;
	private String nomefunc;
	private String cpffunc;
	private String cargo;
	private String salario;
	
	
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public String getNomefunc() {
		return nomefunc;
	}
	public void setNomefunc(String nomefunc) {
		this.nomefunc = nomefunc;
	}
	public String getCpffunc() {
		return cpffunc;
	}
	public void setCpffunc(String cpffunc) {
		this.cpffunc = cpffunc;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	

}
