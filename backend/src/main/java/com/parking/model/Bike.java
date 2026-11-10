package com.parking.model;

public class Bike extends Vehicle {
    private static final double HOURLY_RATE = 10.0;

    public Bike(String plateNumber) {
        super(plateNumber, "BIKE");
    }

    @Override
    public double calculateFee(long hoursParked) {
        return Math.max(1, hoursParked) * HOURLY_RATE;
    }
}