package com.ugahacks.BestRoute.processors;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TravelDistanceProcessor implements Processor {
    //This class will process the travel distance data from an API.
    //Make a constructor that will take in all the data this class needs to process.
    public void process(String origin, String destination) {
        getJSON(origin, destination);
    }

    public String getJSON(String origin, String destination) {
        try {
            String urlC = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination;
            String apiKey = "&key=AIzaSyCF53H3HxflG8kBxxLGHBH4sP_pcEwmNqI";
            OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                .url(urlC+apiKey)
                .method("GET", body)
                .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return "Error: " + e;     
        }
    }
}
