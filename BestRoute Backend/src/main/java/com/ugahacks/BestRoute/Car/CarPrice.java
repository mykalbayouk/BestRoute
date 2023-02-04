package com.ugahacks.BestRoute.Car;

public class CarPrice {
    
    private double a_mpg;
    private double price_per_gallon;
    private double distance;

    public CarPrice(double a_mpg, double price_per_gallon, double distance) {
        this.a_mpg = a_mpg;
        this.price_per_gallon = price_per_gallon;
        this.distance = distance;
    }

    public double getPrice() {
        return (distance / a_mpg) * price_per_gallon;
    }

}
