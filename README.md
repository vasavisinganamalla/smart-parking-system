# Smart Vehicle Parking Allocator

A lightweight full-stack parking management system built to demonstrate core Object-Oriented Programming (OOP) concepts in Java with a straightforward REST API and web UI.

## Tech Stack
- **Backend:** Java 17, Spring Boot (REST Controller, Service Layer)
- **Frontend:** Vanilla HTML5, CSS3, JavaScript (Fetch API)
- **Build Tool:** Maven

## Key OOP Concepts Highlighted
- **Abstraction:** Abstract `Vehicle` base class with `calculateFee()`.
- **Inheritance:** `Car` and `Bike` classes derive common state from `Vehicle`.
- **Polymorphism:** Subclasses override hourly fee computation logic.
- **Encapsulation:** Private properties in `ParkingSpot` and `Vehicle` exposed via public accessors.

## How to Run

1. **Start the Backend:**
   ```bash
   cd backend
   mvn spring-boot:run
2. **Start the Frontend:**
   ```bash
   cd /Users/vasavisinganamalla/projects/smart-parking-system/frontend
   python3 -m http.server 5500
