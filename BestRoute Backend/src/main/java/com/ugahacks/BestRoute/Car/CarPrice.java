package com.ugahacks.BestRoute.Car;

public class CarPrice {
    
    private double a_mpg;
    private double price_per_gallon;
    private double distance;
    private double price_start;
    private double price_end;

    public CarPrice(double a_mpg, double price_per_gallon, double distance) {
        this.a_mpg = a_mpg;
        this.price_per_gallon = price_per_gallon;
        this.distance = distance;
    }

    public double getPrice() {
        return (distance / a_mpg) * price_per_gallon;
    }

    public double getPPG() {
        price_per_gallon = (price_start + price_end) / 2;
        return price_per_gallon;
    }


}
