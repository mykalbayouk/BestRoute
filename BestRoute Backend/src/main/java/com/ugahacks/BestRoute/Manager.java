package com.ugahacks.BestRoute;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Manager {
    
    


    public void getCarPrice() throws MalformedURLException {
        try { 
            URL url = new URL("https://api.api-ninjas.com/v1/cars?");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.addRequestProperty("X-Api-Key", "4UiF3NQnApBFWB8X29ET3FAvJnM1NHjXNzihJ6K0");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            String s = root.findValuesAsText("combination_mpg").get(0);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
