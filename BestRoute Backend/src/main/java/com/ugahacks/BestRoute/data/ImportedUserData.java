package com.ugahacks.BestRoute.data;

public class ImportedUserData {
    //Should contain strings, ints, etc. Basically all the deconstructed data from the frontend.
    //This is the data that will be sent to the manager to be processed.
    //Write this class as a basic class that stores all the data the frontend sends (start location, end location, etc.)
    //The constructor should instantiate all the variables, and getters should be the primary way to access
    private String startingLocation;
    private String endingLocation;
    private String carMake;
    private String carModel;
    private String carYear;
    private String numPeople;

    public ImportedUserData(String startingLocation, String endingLocation, String carMake, String carModel, String carYear, String numPeople) {
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.numPeople = numPeople;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public String getEndingLocation() {
        return endingLocation;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public String getNumPeople() {
        return numPeople;
    }
}
