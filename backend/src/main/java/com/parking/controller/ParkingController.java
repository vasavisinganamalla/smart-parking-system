package com.parking.controller;

import com.parking.model.ParkingSpot;
import com.parking.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parking")
@CrossOrigin(origins = "*")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/spots")
    public List<ParkingSpot> getSpots() {
        return parkingService.getAllSpots();
    }

    @PostMapping("/park")
    public Map<String, String> parkVehicle(@RequestBody Map<String, String> request) {
        String plateNumber = request.get("plateNumber");
        String type = request.get("type");
        String message = parkingService.parkVehicle(plateNumber, type);
        return Map.of("message", message);
    }

    @PostMapping("/exit")
    public Map<String, String> exitVehicle(@RequestBody Map<String, Integer> request) {
        int spotId = request.get("spotId");
        String message = parkingService.exitVehicle(spotId);
        return Map.of("message", message);
    }
}