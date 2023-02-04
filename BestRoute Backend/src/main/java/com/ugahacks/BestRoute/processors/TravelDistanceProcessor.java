package com.ugahacks.BestRoute.processors;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TravelDistanceProcessor {
    //This class will process the travel distance data from an API.
    //Make a constructor that will take in all the data this class needs to process.

    private String jsonString;

    public void process(String origin, String destination) {
        getJSON(origin, destination);
    }

    public void getJSON(String origin, String destination) {
        try {
            String urlC = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination;
            String apiKey = "&key=AIzaSyCF53H3HxflG8kBxxLGHBH4sP_pcEwmNqI";
            OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
            MediaType mediaType = MediaType.parse("text/plain");
            Request request = new Request.Builder()
                .url(urlC+apiKey)
                .get()
                .build();
            Response response = client.newCall(request).execute();
            jsonString = response.body().string();
        } catch (IOException e) {
            System.out.println("Invalid Input");     
        }
    }

    public int getDistance() {
        String output = jsonString.substring(jsonString.indexOf("distance"), jsonString.indexOf("}") + 1);
        return Integer.parseInt(output.substring(output.indexOf("value") + 9, output.indexOf("}")).trim());
    }

    public int getTime() {
        String temp = jsonString.substring(jsonString.indexOf("duration"));
        String output = temp.substring(0, temp.indexOf("}") + 1);
        return Integer.parseInt(output.substring(output.indexOf("value") + 9, output.indexOf("}")).trim());
    }

}
