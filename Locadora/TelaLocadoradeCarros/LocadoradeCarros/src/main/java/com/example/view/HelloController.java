package com.example.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.Carro;
import DTO.Cliente;
import DTO.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {

	@FXML
	private TextField txtCargo;
		
	@FXML
	private TextField txtCPF;
	
	@FXML
	private TextField txtAno;
	
	@FXML
	private TextField txtIdadeFunc;
	
	@FXML
	private TextField txtCor;
	
	@FXML
	private TextField txtEndereco;
	
	@FXML
	private TextField txtIdadeCli;
	
	@FXML
	private TextField txtMarca;
	
	@FXML
	private TextField txtModelo;
	
	@FXML
	private TextField txtNomeCli;
	
	@FXML
	private TextField txtNomeFunc;
	
	@FXML
	private TextField txtPlaca;
	
	@FXML
	private TextField txtPotencia;
	
	@FXML
	private TextField txtPreco;
	
	@FXML
	private TextField txtSalario;
	
	@FXML
	private TextField txtTotal;
	
	@FXML
	void btnCadastrarCarro(ActionEvent event) {
	
		String placa = this.txtPlaca.getText();
		String potencia = this.txtPotencia.getText();
		String modelo = this.txtModelo.getText();
		String cor = this.txtCor.getText();
		String marca = this.txtMarca.getText();
		String ano = this.txtAno.getText();
		String preco = this.txtPreco.getText();
			
	    	
    	Carro objcarro = new Carro(placa, potencia, modelo, cor, marca, ano, preco);
    	
    	objcarro.setPlaca(placa);
    	objcarro.setPotencia(potencia);
    	objcarro.setModelo(modelo);
    	objcarro.setCor(cor);
    	objcarro.setMarca(marca);
    	objcarro.setAno(ano);
    	objcarro.setPreco(preco);
    	
    	System.out.println("Placa: " + objcarro.getPlaca());
    	System.out.println("Potência: " + objcarro.getPotencia());
    	System.out.println("Modelo: " + objcarro.getModelo());
    	System.out.println("Cor: " + objcarro.getCor());
    	System.out.println("Marca: " + objcarro.getMarca());
    	System.out.println("Ano: " + objcarro.getAno());
    	System.out.println("Preço:" + objcarro.getPreco());

    	
    	ArrayList<String> Carro = new ArrayList<String>();
    	
    	Carro.add(objcarro.getPlaca());
    	Carro.add(objcarro.getPotencia());
    	Carro.add(objcarro.getModelo());
    	Carro.add(objcarro.getCor());
    	Carro.add(objcarro.getMarca());
    	Carro.add(objcarro.getAno());
    	Carro.add(objcarro.getPreco());
    	
    	System.out.println("\n"+Carro);
    	
    	JOptionPane.showMessageDialog(null, Carro);
    }
	
	@FXML
	void btnCadastrarCliente(ActionEvent event) {
    	String nomecli = this.txtNomeCli.getText();
    	String idadecli = this.txtIdadeCli.getText();
    	String cpf = this.txtCPF.getText();
    	String endereco = this.txtEndereco.getText();
    	String total = this.txtTotal.getText();
    	
    	Cliente objclientedto = new Cliente(nomecli, idadecli, cpf, endereco, total);
    	
    	objclientedto.setNomeCli(nomecli);
    	objclientedto.setIdadeCli(idadecli);
    	objclientedto.setCPF(cpf);
    	objclientedto.setEndereco(endereco);
    	objclientedto.setTotal(total);
    	
    	System.out.println("Nome Cliente: " + objclientedto.getNomeCli());
    	System.out.println("Idade Cliente: " + objclientedto.getIdadeCli());
    	System.out.println("CPF: " + objclientedto.getCPF());
    	System.out.println("Endereço: " + objclientedto.getEndereco());
    	System.out.println("Total A Pagar: " + objclientedto.getTotal());
    	
    	ArrayList<String> Cliente = new ArrayList<String>();
    	Cliente.add(objclientedto.getNomeCli());
    	Cliente.add(objclientedto.getIdadeCli());
    	Cliente.add(objclientedto.getCPF());
    	Cliente.add(objclientedto.getEndereco());
    	Cliente.add(objclientedto.getTotal());
    	
    	System.out.println("\n" + Cliente);
    	
    	JOptionPane.showMessageDialog(null, Cliente);
    }
	
    @FXML
    void btnCadastrarFuncionario(ActionEvent event) {
    	String nomefunc = this.txtNomeFunc.getText();
    	String idadefunc = this.txtIdadeFunc.getText();
    	String cargo = this.txtCargo.getText();
    	String salario = this.txtSalario.getText();
    	
    	Funcionario objfunc = new Funcionario(nomefunc, idadefunc, cargo, salario);
    	
    	objfunc.setNomeFunc(nomefunc);
    	objfunc.setIdadeFunc(idadefunc);
    	objfunc.setCargo(cargo);
    	objfunc.setSalario(salario);
    	
    	ArrayList<String> Funcionario = new ArrayList<String>();
    	
    	Funcionario.add(objfunc.getNomeFunc());
    	Funcionario.add(objfunc.getIdadeFunc());
    	Funcionario.add(objfunc.getCargo());
    	Funcionario.add(objfunc.getSalario());
  
    	System.out.println("Nome Funcionário: " + objfunc.getNomeFunc());
    	System.out.println("Idade Funcionário: " + objfunc.getIdadeFunc());
    	System.out.println("Cargo: " + objfunc.getCargo());
    	System.out.println("Salário: " + objfunc.getSalario());
    	
    	System.out.println("\n" + Funcionario);
    	
    	JOptionPane.showMessageDialog(null, Funcionario);
    }

}