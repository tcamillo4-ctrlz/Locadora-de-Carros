package com.example.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LocadoraApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LocadoraApplication.class.getResource("/view/TelaLocadora.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 367,297);
        stage.setTitle("Locadora");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.getIcons().add(new Image("https://raw.githubusercontent.com/tcamillo4-ctrlz/Locadora-de-Carros/main/Locadora/TelaLocadoradeCarros/Logo/LogoLocadoradeCarros.jpeg"));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}