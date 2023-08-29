module com.guiweather.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.guiweather.weatherapp to javafx.fxml,com.fasterxml.jackson.databind;
    exports com.guiweather.weatherapp;
}