package com.guiweather.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Controller2 {
    @FXML
    private Label one,two,three,four,five,six,seven,results, additional,git;
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane rootPane;

    private Stage primaryStage; // Reference to the primary stage

    // Method to set the primary stage
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    protected void onupdate(WeatherDATA value) throws IOException {
        one.setText(value.current.condition.text);
        two.setText("Temperature: "+ value.current.temp_c);
        three.setText("Country: "+ value.location.country);
        four.setText(value.location.name);
        five.setText("Region: "+ value.location.region);
        six.setText("Timezone: "+ value.location.tz_id);
        seven.setText("Local Time: "+ value.location.localtime);
        Image image = new Image("https:"+value.current.condition.icon);
        imageView.setImage(image);
        if(value.current.is_day==1){
            rootPane.setStyle("-fx-background-color: #87CEEB;");
        } else {
            rootPane.setStyle("-fx-background-color: #333333;");
        }
        Label[] labelarray = {one,two,three,four,five,six,seven,results,additional,git};
        for(Label element:labelarray){
            if(value.current.is_day!=1) {
                element.setStyle("-fx-text-fill: #FFFFFF;");
            }
        }
    }

    @FXML
    protected void onReturn() throws IOException {
        Application.returnhome(primaryStage);
    }

    @FXML
    protected void onUpdateClick() throws IOException {

        WeatherDATA value = Main.CheckWeather(Controller1.text);
        Application.showdata(primaryStage, value);
    }

    @FXML
    protected void loc1() throws IOException {
        File file = new File("recentlocation.txt");
        Scanner file_reader = new Scanner(file);
        String line1 = file_reader.nextLine();
        Controller1.text = line1;
        file_reader.close();
        WeatherDATA value = Main.CheckWeather(line1);
        if(value==null) {
            Application.errorpop1(primaryStage);
        } else {
            Application.showdata(primaryStage, value);
        }
    }
}
