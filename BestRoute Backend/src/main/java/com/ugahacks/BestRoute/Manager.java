package com.ugahacks.BestRoute;

import com.ugahacks.BestRoute.data.ExportableUserData;
import com.ugahacks.BestRoute.data.ImportedUserData;
import com.ugahacks.BestRoute.processors.FlightCostProcessor;
import com.ugahacks.BestRoute.processors.GasPriceProcessor;
import com.ugahacks.BestRoute.processors.MilePerGallonProcessor;
import com.ugahacks.BestRoute.processors.TravelDistanceProcessor;

public class Manager {

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
