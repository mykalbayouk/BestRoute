package com.ugahacks.BestRoute.processors;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TravelDistanceProcessor implements Processor {
    //This class will process the travel distance data from an API.
    //Make a constructor that will take in all the data this class needs to process.
    public void process() {
        throw new UnsupportedOperationException();
    }

    public String getJSON() {
        try {
        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
            .url("https://maps.googleapis.com/maps/api/distancematrix/json?origins=849VCWC8%2BR9&destinations=San%20Francisco&key=YOUR_API_KEY")
            .method("GET", body)
            .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
        } catch (IOException e) {
            throw new IllegalArgumentException("improper input");
        } catch (Exception e) {
            throw new IllegalArgumentException("improper input");
        }
    }
}
