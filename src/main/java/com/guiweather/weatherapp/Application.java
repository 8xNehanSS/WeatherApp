package com.guiweather.weatherapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view2.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("116.png"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Weather Forecast");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        Controller2 controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);
        controller.loc1();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void errorpop(Stage stage) throws IOException {
        Alert alert = new Alert(AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Weather Forecast");
        alert.setHeaderText("An error occurred");
        alert.setContentText("Please enter a location name before clicking search!");

        alert.showAndWait();
    }

    public static void errorpop1(Stage stage) throws IOException {
        Alert alert = new Alert(AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Weather Forecast");
        alert.setHeaderText("An error occurred");
        alert.setContentText("Contact dev for further information");

        alert.showAndWait();
    }

    public static void showdata(Stage stage, WeatherDATA value) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Weather Forecast");
        stage.setScene(scene);
        stage.show();
        Controller2 controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);
        controller.onupdate(value);
    }

    public static void returnhome(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Weather Forecast");
        stage.setScene(scene);
        stage.show();
        Controller1 controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);
    }
}