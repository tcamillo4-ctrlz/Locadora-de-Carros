package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LocadoraController implements Initializable{

	public void initialize(URL location, ResourceBundle resources) {}
	
	@FXML
	void btnCarro(){

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/TelaCarro.fxml"));
		Scene scene = null;
		try {
			scene = new Scene((Parent) fxmlLoader.load(), 670, 440);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Tela Carro");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/tcamillo4-ctrlz/Locadora-de-Carros/main/Locadora/TelaLocadoradeCarros/Logo/LogoLocadoradeCarros.jpeg"));
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	void btnCliente(){

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/TelaCliente.fxml"));
		Scene scene = null;
		try {
			scene = new Scene((Parent) fxmlLoader.load(), 670, 440);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Tela Cliente");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/tcamillo4-ctrlz/Locadora-de-Carros/main/Locadora/TelaLocadoradeCarros/Logo/LogoLocadoradeCarros.jpeg"));
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	void btnFuncionario(){

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/TelaFuncionario.fxml"));
		Scene scene = null;
		try {
			scene = new Scene((Parent) fxmlLoader.load(), 670, 440);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Tela Funcionario");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/tcamillo4-ctrlz/Locadora-de-Carros/main/Locadora/TelaLocadoradeCarros/Logo/LogoLocadoradeCarros.jpeg"));
		stage.setScene(scene);
		stage.show();

	}

	
	
}
