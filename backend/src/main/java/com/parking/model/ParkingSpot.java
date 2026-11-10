package com.parking.model;

public class ParkingSpot {
    private int spotId;
    private boolean occupied;
    private Vehicle parkedVehicle;
    private long entryTimeMillis;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
        this.occupied = false;
        this.parkedVehicle = null;
        this.entryTimeMillis = 0;
    }

    public int getSpotId() {
        return spotId;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.occupied = true;
        this.entryTimeMillis = System.currentTimeMillis();
    }

    public double vacate() {
        if (!occupied || parkedVehicle == null) {
            return 0.0;
        }
        long durationMillis = System.currentTimeMillis() - entryTimeMillis;
        long hours = durationMillis / (1000 * 60 * 60);
        double fee = parkedVehicle.calculateFee(hours);
        this.parkedVehicle = null;
        this.occupied = false;
        this.entryTimeMillis = 0;
        return fee;
    }
}