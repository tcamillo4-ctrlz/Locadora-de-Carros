package DTO;

public class Carro{

    // Atributos da Classe -> Características
	
    String placa;
    String potencia;
    String modelo;
    String cor;
    String marca;
    String ano;
    String preco;

    // Métodos -> Ações

    public Carro(String placa, String potencia, String modelo, String cor, String marca, String ano, String preco) {
		this.placa = placa;
		this.potencia = potencia;
		this.modelo = modelo;
		this.cor = cor;
		this.marca = marca;
		this.ano = ano;
		this.preco = preco;
	}
    
    ///////////////////////////////////////////
    public void setPlaca(String placa) {
		this.placa = placa;
	}
    public String getPlaca() {
		return placa;
	}
    ///////////////////////////////////////////
    public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
    public String getPotencia() {
		return potencia;
	}
    ///////////////////////////////////////////
    public void setModelo(String modelo) {
		this.modelo = modelo;
	}
    public String getModelo() {
		return modelo;
	}
    ///////////////////////////////////////////
    public void setCor(String cor) {
		this.cor = cor;
	}
    public String getCor() {
		return cor;
	}
    ///////////////////////////////////////////
    public void setMarca(String marca) {
		this.marca = marca;
	}
    public String getMarca() {
		return marca;
	}
    ///////////////////////////////////////////
    public void setAno(String ano) {
		this.ano = ano;
	}
    public String getAno() {
		return ano;
	}
    ///////////////////////////////////////////
    public void setPreco(String preco) {
		this.preco = preco;
	}
    public String getPreco() {
		return preco;
	}

}