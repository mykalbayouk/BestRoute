package com.ugahacks.BestRoute.processors;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MilePerGallonProcessor implements Processor {
    //This class will process the mile per gallon data from an API.
    //Make a constructor that will take in all the data this class needs to process.
    private String api_MPG;



    public void process(String make, String model, String year) {
        getAPI(make, model, year);
    }

    public void getAPI(String make, String model, String year) {
        try { 
            String url_create = "https://api.api-ninjas.com/v1/cars?make="+ make + "&model=" + model + "&year=" + year;
            URL url = new URL(url_create);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.addRequestProperty("X-Api-Key", "4UiF3NQnApBFWB8X29ET3FAvJnM1NHjXNzihJ6K0");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            api_MPG = root.findValuesAsText("combination_mpg").get(0);
        } catch (IOException e) {
            e.printStackTrace(); 
        } // try catch
    } // getAPI
    public int getMPG() {
        return Integer.parseInt(api_MPG);
    }

}
