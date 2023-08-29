package com.guiweather.weatherapp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    static String APIKEY = "357abd1f39fe470d80c135938232308"; //api key from https://www.weatherapi.com
    public static void main(String[] args) {
        String separator = "+----------------------------------+";
        System.out.println(separator);
        System.out.println("|           Weather Data           |");
        System.out.println(separator);
//        Application.main(args);
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter the city name (99 to EXIT APP): ");
            String location = scanner.next();
            if(location.equals("99")) {
                System.out.println("Exiting app..");
                System.exit(0);
            }
            System.out.println("\nLoading Data..\n");
            WeatherDATA value = CheckWeather(location);
        }
    }

    public static WeatherDATA CheckWeather(String location) {
        try {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + APIKEY + "&q="+ location +"&aqi=no");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("accept", "application/json");

            InputStream responseStream = connection.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            WeatherDATA data = mapper.readValue(responseStream, WeatherDATA.class);


            String separator = "+----------------------------------+";
            String weatherData = separator + "\n" +
                    "|           Weather Data           |\n" +
                    separator + "\n" +
                    "| Condition:         " + data.current.condition.text + "\n" +
                    "| Temperature:       " + data.current.temp_c + " °C\n" +
                    "| City Name:         " + data.location.name + "\n" +
                    "| Country:           " + data.location.country + "\n" +
                    "| Region:            " + data.location.region + "\n" +
                    "| Timezone:          " + data.location.tz_id + "\n" +
                    "| Local Time:        " + data.location.localtime + "\n" +
                    separator;
            System.out.println(weatherData);

            return data;




        } catch (Exception e) {
            System.out.println("Location not found. Try Again!");

            e.printStackTrace();
            return null;
        }
    }
}
