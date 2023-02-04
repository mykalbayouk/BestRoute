package com.ugahacks.BestRoute.processors;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;

public class FlightCostProcessor {
    //This class will process the flight cost data from an API.
    //Make a constructor that will take in all the data this class needs to process.
    private String jsonString;
    private double lon;
    private double lat;
    private int count;
    private String origin;
    private String destination;
    private int numPeople;

    public FlightCostProcessor(String origin, String destination, int numPeople) {
        this.origin = origin;
        this.destination = destination;
    }
        
    public void process(String origin, String destination, int numPeople) {
        getJSON(getIATA(getLonLat(origin), 0), getIATA(getLonLat(destination), 0), numPeople);    
    }

    private void getJSON(String origin, String destination, int numPeople) {
        System.out.println("Origin: " + origin + " Destination: " + destination + " NumPeople: " + numPeople);
        String buildURL = "https://skyscanner50.p.rapidapi.com/api/v1/searchFlights?" +
            "origin=" + origin + 
            "&destination=" + destination + 
            "&date=" + getDate() + 
            "&adults=" + numPeople + 
            "&currency=USD&countryCode=US&market=en-US";
        try {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
	        .url(buildURL)
	        .get()
	        .addHeader("X-RapidAPI-Key", "f984583381msh198a1863bc1426ap1f4886jsn30306581a5fa")
	        .addHeader("X-RapidAPI-Host", "skyscanner50.p.rapidapi.com")
	        .build();        
            Response response = client.newCall(request).execute();
            jsonString = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Invalid Input");
        }
    }

    public double getCost() {
        String temp = "";
        String output = "";
        try {
            temp = jsonString.substring(jsonString.indexOf("price"));
            output = jsonString.substring(jsonString.indexOf("price"), temp.indexOf("}"));
        } catch (StringIndexOutOfBoundsException e) {
            count++;
            getJSON(getIATA(getLonLat(origin), 0), getIATA(getLonLat(destination), 0), numPeople);
        }
        return Double.parseDouble(output.substring(17));
    }

    private String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        now = now.plus(7, ChronoUnit.DAYS);
        return dtf.format(now);
    }

    private String getIATA(String input, int count) {
        String lon = input.substring(0, input.indexOf(","));
        String lat = input.substring(input.indexOf(",") + 1);
        String fullJson = "";
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                .url("https://airlabs.co/api/v9/nearby?" + "lat=" +
                    lat + "&lng=" + lon + "&distance=100&api_key=8b6ca479-8c6c-456d-a986-2193c31a7bb4")
                .get()
                .build();        
                Response response = client.newCall(request).execute();
                fullJson = response.body().string();
            } catch (IOException e) {
                throw new RuntimeException("Invalid Input");
            }
        String[] iataList = new String[10];
        int j = 0;
        for (int i = 0; i < fullJson.length() - 4; i++) {
            if (fullJson.substring(i, i + 4).equals("iata") && j < 10) {
                iataList[j] = fullJson.substring(i + 12, i + 15);
                j++;
            }            
        }
        return iataList[count];
    }

    private String getLonLat(String location) {
        String geoJSON = "";
        try {
            String urlC = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location;
            String apiKey = "&key=AIzaSyDp5yFSXXwLEz5qpC00CnzTqxGuzsv8_Qc";
            OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
            Request request = new Request.Builder()
                .url(urlC + apiKey)
                .get()
                .build();
            Response response = client.newCall(request).execute();
            geoJSON = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Invalid Input");     
        }
        String temp = geoJSON.substring(geoJSON.indexOf("location"));
        String output = temp.substring(0, temp.indexOf("}"));
        String lon = (output.substring(output.indexOf("lng") + 7, output.indexOf("lng") + 14));
        String lat = (output.substring(output.indexOf("lat") + 7, output.indexOf("lat") + 14));
        return lon + "," + lat;
    }


}
