package com.ugahacks.BestRoute;

import com.ugahacks.BestRoute.data.ExportableUserData;
import com.ugahacks.BestRoute.data.ImportedUserData;
import com.ugahacks.BestRoute.processors.FlightCostProcessor;
import com.ugahacks.BestRoute.processors.GasPriceProcessor;
import com.ugahacks.BestRoute.processors.MilePerGallonProcessor;
import com.ugahacks.BestRoute.processors.TravelDistanceProcessor;

public class Manager {

    private final ImportedUserData data;
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
        flightCostProcessor.process(data.getStartingLocation(), data.getEndingLocation(), Integer.parseInt(data.getNumPeople()));
        gasPriceProcessor.process(data.getStartingLocation(), data.getEndingLocation());
        travelDistanceProcessor.process(data.getStartingLocation(), data.getEndingLocation());
        milePerGallonProcessor.process(data.getCarMake(), data.getCarModel(), data.getCarYear());
    }

    public ExportableUserData export() {
        return new ExportableUserData(calcDriveCost(), calcDriveTime(), calcFlightCost(), calcFlightTime());
    }

    public String calcDriveCost() {
        double miles = travelDistanceProcessor.getDistance() / 1609.344;
        int mpg = milePerGallonProcessor.getMPG();
        double ppg = gasPriceProcessor.getPPG();
        System.out.println("Miles: " + miles + " MPG: " + mpg + " PPG: " + ppg);
        double cost = (miles / mpg) * ppg;
        return String.valueOf(cost);
    }

    public String calcDriveTime() {
        double time = travelDistanceProcessor.getTime() / 3600.0;
        return String.valueOf(time);
    }

    public String calcFlightCost() {
        double cost = flightCostProcessor.getCost();
        return String.valueOf(cost);
    }

    public String calcFlightTime() {
        return "" + travelDistanceProcessor.getDistance() / 850000.0;
    }
}
