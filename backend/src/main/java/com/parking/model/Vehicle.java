package com.parking.model;

public abstract class Vehicle {
    private String plateNumber;
    private String vehicleType;

    public Vehicle(String plateNumber, String vehicleType) {
        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public abstract double calculateFee(long hoursParked);
}
