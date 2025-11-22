// Initialize map
const map = L.map('map').setView([4.6097, -74.0817], 13); // Default to Bogotá, Colombia

// Add OpenStreetMap tiles
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© OpenStreetMap contributors',
    maxZoom: 19
}).addTo(map);

// State
let currentPosition = null;
let currentMarker = null;
let locationMarkers = [];

// API Base URL
const API_BASE = '/advance/v1';

// Get DOM elements
const getCurrentLocationBtn = document.getElementById('getCurrentLocation');
const saveLocationBtn = document.getElementById('saveLocation');
const loadLocationsBtn = document.getElementById('loadLocations');
const userIdInput = document.getElementById('userId');
const statusDiv = document.getElementById('status');
const currentLatSpan = document.getElementById('currentLat');
const currentLngSpan = document.getElementById('currentLng');
const accuracySpan = document.getElementById('accuracy');
const timestampSpan = document.getElementById('timestamp');

// Show status message
function showStatus(message, type = 'info') {
    statusDiv.textContent = message;
    statusDiv.className = `status ${type}`;
    statusDiv.style.display = 'block';
    
    setTimeout(() => {
        statusDiv.style.display = 'none';
    }, 5000);
}

// Update location info display
function updateLocationInfo(lat, lng, accuracy, timestamp) {
    currentLatSpan.textContent = lat.toFixed(6);
    currentLngSpan.textContent = lng.toFixed(6);
    accuracySpan.textContent = accuracy ? `${accuracy.toFixed(0)} meters` : '-';
    timestampSpan.textContent = timestamp || new Date().toLocaleString();
}

// Get current location using Geolocation API
getCurrentLocationBtn.addEventListener('click', () => {
    if (!navigator.geolocation) {
        showStatus('Geolocation is not supported by your browser', 'error');
        return;
    }
    
    showStatus('Getting your location...', 'info');
    getCurrentLocationBtn.disabled = true;
    
    navigator.geolocation.getCurrentPosition(
        (position) => {
            const lat = position.coords.latitude;
            const lng = position.coords.longitude;
            const accuracy = position.coords.accuracy;
            
            currentPosition = {
                latitude: lat,
                longitude: lng,
                accuracy: accuracy
            };
            
            // Update map
            map.setView([lat, lng], 15);
            
            // Remove old marker if exists
            if (currentMarker) {
                map.removeLayer(currentMarker);
            }
            
            // Add new marker
            currentMarker = L.marker([lat, lng])
                .addTo(map)
                .bindPopup('📍 Your current location')
                .openPopup();
            
            // Add accuracy circle
            L.circle([lat, lng], {
                radius: accuracy,
                color: '#3498db',
                fillColor: '#3498db',
                fillOpacity: 0.1
            }).addTo(map);
            
            // Update info display
            updateLocationInfo(lat, lng, accuracy, new Date().toLocaleString());
            
            showStatus('Location retrieved successfully!', 'success');
            saveLocationBtn.disabled = false;
            getCurrentLocationBtn.disabled = false;
        },
        (error) => {
            let errorMessage = 'Unable to retrieve your location';
            switch(error.code) {
                case error.PERMISSION_DENIED:
                    errorMessage = 'Location permission denied. Please enable location access.';
                    break;
                case error.POSITION_UNAVAILABLE:
                    errorMessage = 'Location information is unavailable.';
                    break;
                case error.TIMEOUT:
                    errorMessage = 'Location request timed out.';
                    break;
            }
            showStatus(errorMessage, 'error');
            getCurrentLocationBtn.disabled = false;
        },
        {
            enableHighAccuracy: true,
            timeout: 10000,
            maximumAge: 0
        }
    );
});

// Save location to server
saveLocationBtn.addEventListener('click', async () => {
    if (!currentPosition) {
        showStatus('Please get your current location first', 'error');
        return;
    }
    
    const userId = parseInt(userIdInput.value);
    if (!userId || userId <= 0) {
        showStatus('Please enter a valid user ID', 'error');
        return;
    }
    
    saveLocationBtn.disabled = true;
    showStatus('Saving location...', 'info');
    
    try {
        const response = await fetch(`${API_BASE}/location`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                latitude: currentPosition.latitude,
                longitude: currentPosition.longitude,
                userId: userId,
                timestamp: new Date().toISOString()
            })
        });
        
        if (response.ok) {
            const data = await response.json();
            showStatus('Location saved successfully!', 'success');
            
            // Update marker popup
            if (currentMarker) {
                currentMarker.setPopupContent('✅ Location saved!');
                currentMarker.openPopup();
            }
        } else {
            showStatus('Failed to save location. Please try again.', 'error');
        }
    } catch (error) {
        console.error('Error saving location:', error);
        showStatus('Error saving location. Check console for details.', 'error');
    } finally {
        saveLocationBtn.disabled = false;
    }
});

// Load locations from server
loadLocationsBtn.addEventListener('click', async () => {
    const userId = parseInt(userIdInput.value);
    if (!userId || userId <= 0) {
        showStatus('Please enter a valid user ID', 'error');
        return;
    }
    
    loadLocationsBtn.disabled = true;
    showStatus('Loading locations...', 'info');
    
    try {
        const response = await fetch(`${API_BASE}/location/${userId}`);
        
        if (response.ok) {
            const locations = await response.json();
            
            // Clear existing location markers
            locationMarkers.forEach(marker => map.removeLayer(marker));
            locationMarkers = [];
            
            if (locations.length === 0) {
                showStatus('No locations found for this user', 'info');
            } else {
                // Add markers for each location
                locations.forEach((location, index) => {
                    const marker = L.marker([location.latitude, location.longitude])
                        .addTo(map)
                        .bindPopup(`
                            <b>Location ${index + 1}</b><br>
                            Lat: ${location.latitude.toFixed(6)}<br>
                            Lng: ${location.longitude.toFixed(6)}<br>
                            Time: ${new Date(location.timestamp).toLocaleString()}
                        `);
                    locationMarkers.push(marker);
                });
                
                // Fit map to show all markers
                if (locations.length > 0) {
                    const bounds = L.latLngBounds(
                        locations.map(loc => [loc.latitude, loc.longitude])
                    );
                    map.fitBounds(bounds, { padding: [50, 50] });
                }
                
                showStatus(`Loaded ${locations.length} location(s)`, 'success');
            }
        } else {
            showStatus('Failed to load locations', 'error');
        }
    } catch (error) {
        console.error('Error loading locations:', error);
        showStatus('Error loading locations. Check console for details.', 'error');
    } finally {
        loadLocationsBtn.disabled = false;
    }
});

// Auto-detect location on page load
window.addEventListener('load', () => {
    showStatus('Welcome! Click "Get Current Location" to start tracking', 'info');
});
