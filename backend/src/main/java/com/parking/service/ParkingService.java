package com.parking.service;

import com.parking.model.Bike;
import com.parking.model.Car;
import com.parking.model.ParkingSpot;
import com.parking.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService {
    private final List<ParkingSpot> spots = new ArrayList<>();

    public ParkingService() {
        for (int i = 1; i <= 6; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    public List<ParkingSpot> getAllSpots() {
        return spots;
    }

    public String parkVehicle(String plateNumber, String type) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getParkedVehicle().getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return "Vehicle already parked in Spot #" + spot.getSpotId();
            }
        }

        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                Vehicle vehicle = "BIKE".equalsIgnoreCase(type) ? new Bike(plateNumber) : new Car(plateNumber);
                spot.park(vehicle);
                return "Parked successfully in Spot #" + spot.getSpotId();
            }
        }
        return "Parking Lot Full";
    }

    public String exitVehicle(int spotId) {
        for (ParkingSpot spot : spots) {
            if (spot.getSpotId() == spotId) {
                if (!spot.isOccupied()) {
                    return "Spot #" + spotId + " is already empty";
                }
                double fee = spot.vacate();
                return "Vehicle exited from Spot #" + spotId + ". Total Fee: ₹" + fee;
            }
        }
        return "Invalid Spot ID";
    }
}