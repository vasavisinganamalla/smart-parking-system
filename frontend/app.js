const API_URL = "http://localhost:8080/api/parking";

async function fetchSpots() {
    try {
        const response = await fetch(`${API_URL}/spots`);
        const spots = await response.json();
        renderSpots(spots);
    } catch (error) {
        showMessage("Backend offline. Start Spring Boot on port 8080.", true);
    }
}

function renderSpots(spots) {
    const grid = document.getElementById("parkingGrid");
    grid.innerHTML = "";

    spots.forEach(spot => {
        const div = document.createElement("div");
        div.className = `spot-card ${spot.occupied ? "spot-occupied" : "spot-available"}`;

        if (spot.occupied) {
            div.innerHTML = `
                <h3>Spot #${spot.spotId}</h3>
                <p><strong>Status:</strong> Occupied</p>
                <p><strong>Plate:</strong> ${spot.parkedVehicle.plateNumber}</p>
                <p><strong>Type:</strong> ${spot.parkedVehicle.vehicleType}</p>
                <button onclick="handleExit(${spot.spotId})">Vacate & Bill</button>
            `;
        } else {
            div.innerHTML = `
                <h3>Spot #${spot.spotId}</h3>
                <p><strong>Status:</strong> Empty</p>
                <p style="color:#64748b;">Ready to park</p>
            `;
        }
        grid.appendChild(div);
    });
}

async function handlePark() {
    const plateInput = document.getElementById("plateInput");
    const typeSelect = document.getElementById("typeSelect");
    const plateNumber = plateInput.value.trim();
    const type = typeSelect.value;

    if (!plateNumber) {
        showMessage("Please enter a license plate number.");
        return;
    }

    const response = await fetch(`${API_URL}/park`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ plateNumber, type })
    });

    const data = await response.json();
    showMessage(data.message);
    plateInput.value = "";
    fetchSpots();
}

async function handleExit(spotId) {
    const response = await fetch(`${API_URL}/exit`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ spotId })
    });

    const data = await response.json();
    showMessage(data.message);
    fetchSpots();
}

function showMessage(text) {
    const box = document.getElementById("statusMessage");
    box.style.display = "block";
    box.innerText = text;
}

window.onload = fetchSpots;