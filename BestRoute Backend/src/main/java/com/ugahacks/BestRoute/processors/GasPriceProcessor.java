package com.ugahacks.BestRoute.processors;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GasPriceProcessor {
    //This class will process the gas price data from an API.
    //Make a constructor that will take in all the data this class needs to process.

    private double gasPriceOrigin;
    private double gasPriceDestination;

    private String fullJson;

    public void process(String originState, String destinationState) {
        gasPriceOrigin = getJSON(originState);
        gasPriceDestination = getJSON(destinationState);
    }

    private double getJSON(String location) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                .url("https://api.collectapi.com/gasPrice/stateUsaPrice?state=" + location)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "apikey 6pJ11SI3HigwS2sxVwfqHy:1YctclQtEhNAXMgLzyVO0k")
                .get()
                .build();        
            Response response = client.newCall(request).execute();
            fullJson = response.body().string();
        } catch (IOException e) {
            System.out.println("Invalid Input");
        }
        return Double.parseDouble(fullJson.substring(fullJson.indexOf("gasoline") + 8, fullJson.indexOf("gasoline") + 12));   
    }

    public double getGasPrice() {
        return (gasPriceOrigin + gasPriceDestination) / 2;
    }
}
