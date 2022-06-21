package com.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TelaLocadoradeCarros.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 500, 450);
        stage.setTitle("Locadora de Carros");
        stage.setScene(scene);
        stage.getIcons().add(new Image("https://raw.githubusercontent.com/tcamillo4-ctrlz/Locadora-de-Carros/main/Locadora/TelaLocadoradeCarros/Logo/LogoLocadoradeCarros.jpeg"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}