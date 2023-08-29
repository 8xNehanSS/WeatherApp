package com.guiweather.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller1 {
    @FXML
    private TextField text1;

    private Stage primaryStage; // Reference to the primary stage

    public static String text;

    // Method to set the primary stage
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
    @FXML
    protected void onSearchButtonClick() throws IOException {
        text = text1.getText().toLowerCase().trim().replaceAll("\\s+", "");
        if(text.equals("")){
            Application.errorpop(primaryStage);
        } else {
            WeatherDATA value = Main.CheckWeather(text);
            if(value==null) {
                Application.errorpop1(primaryStage);
            } else {
                Application.showdata(primaryStage, value);
            }
        }
    }

    @FXML
    protected void loc1() throws IOException {
        text = "tokyo";
        WeatherDATA value = Main.CheckWeather("tokyo");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc2() throws IOException {
        text = "colombo";
        WeatherDATA value = Main.CheckWeather("colombo");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc3() throws IOException {
        text = "gampaha";
        WeatherDATA value = Main.CheckWeather("gampaha");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc4() throws IOException {
        text = "narita";
        WeatherDATA value = Main.CheckWeather("narita");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc5() throws IOException {
        text = "london";
        WeatherDATA value = Main.CheckWeather("london");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc6() throws IOException {
        text = "chennai";
        WeatherDATA value = Main.CheckWeather("chennai");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc7() throws IOException {
        text = "veyangoda";
        WeatherDATA value = Main.CheckWeather("veyangoda");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc8() throws IOException {
        text = "kandy";
        WeatherDATA value = Main.CheckWeather("kandy");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

    @FXML
    protected void loc9() throws IOException {
        text = "jaffna";
        WeatherDATA value = Main.CheckWeather("jaffna");
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }

}