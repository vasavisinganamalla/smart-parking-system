package com.parking.model;

public class Car extends Vehicle {
    private static final double HOURLY_RATE = 20.0;

    public Car(String plateNumber) {
        super(plateNumber, "CAR");
    }

    @Override
    public double calculateFee(long hoursParked) {
        return Math.max(1, hoursParked) * HOURLY_RATE;
    }
}