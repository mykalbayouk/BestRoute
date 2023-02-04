package com.ugahacks.BestRoute;

import com.ugahacks.BestRoute.data.ExportableUserData;
import com.ugahacks.BestRoute.data.ImportedUserData;
import com.ugahacks.BestRoute.processors.FlightCostProcessor;
import com.ugahacks.BestRoute.processors.GasPriceProcessor;
import com.ugahacks.BestRoute.processors.MilePerGallonProcessor;
import com.ugahacks.BestRoute.processors.TravelDistanceProcessor;

public class Manager {
    //Rough starter code for API calls
    /*URL url = new URL("https://api.api-ninjas.com/v1/cars?model=camry");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.addRequestProperty("X-Api-Key", "4UiF3NQnApBFWB8X29ET3FAvJnM1NHjXNzihJ6K0");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            String s = root.findValuesAsText("combination_mpg").get(0);*/

    private final ImportedUserData data;
    private ExportableUserData exportableUserData;
    private final FlightCostProcessor flightCostProcessor;
    private final MilePerGallonProcessor milePerGallonProcessor;
    private final GasPriceProcessor gasPriceProcessor;
    private final TravelDistanceProcessor travelDistanceProcessor;

    public Manager(ImportedUserData data) {
        this.data = data;
        flightCostProcessor = new FlightCostProcessor();
        milePerGallonProcessor = new MilePerGallonProcessor();
        gasPriceProcessor = new GasPriceProcessor();
        travelDistanceProcessor = new TravelDistanceProcessor();
    }

    protected void process() {
        flightCostProcessor.process();
        milePerGallonProcessor.process();
        gasPriceProcessor.process();
        travelDistanceProcessor.process();
    }

    public ExportableUserData export() {
        return exportableUserData;
    }

}
