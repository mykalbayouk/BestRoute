package com.ugahacks.BestRoute.data;

public class ExportableUserData {
    //Should contain strings, ints, etc. Basically all the deconstructed data from the backend.
    //This is the data that will be sent to the frontend to be displayed after the manager has processed the data.

    private String driveCost;
    private String driveTime;
    private String flightCost;
    private String flightTime;

    public ExportableUserData(String driveCost, String driveTime, String flightCost, String flightTime) {
        this.driveCost = driveCost;
        this.driveTime = driveTime;
        this.flightCost = flightCost;
        this.flightTime = flightTime;
    } // ExportableUserData

    public ExportableUserData() {
        this.driveCost = "Failure";
        this.driveTime = "Failure";
        this.flightCost = "Failure";
        this.flightTime = "Failure";

    }

    public String getDriveCost() {
        return driveCost;
    } // getDriveCost

    public String getDriveTime() {
        return driveTime;
    } // getDriveTime

    public String getFlightCost() {
        return flightCost;
    } // getFlightCost

    public String getFlightTime() {
        return flightTime;
    } // getFlightTime
}
