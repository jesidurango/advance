# Location Tracker Feature

## Overview
This feature provides real-time location tracking capabilities for users via a web interface. Users can access the map on their mobile devices or computers to track and save their GPS location.

## Features
- 📍 Get current location using HTML5 Geolocation API
- 💾 Save location to database with timestamp
- 🗺️ Interactive map using Leaflet.js and OpenStreetMap
- 📱 Mobile-responsive design
- 📊 View location history for users
- 🎯 Accurate positioning with accuracy indicators

## How to Use

### Accessing the Map
1. Start the Spring Boot application
2. Navigate to: `http://localhost:8080/advance/map.html`
3. Allow location permissions when prompted by your browser

### Tracking Location
1. **Enter User ID**: Input a valid user ID in the form
2. **Get Current Location**: Click "Get Current Location" to retrieve your GPS coordinates
3. **Save Location**: Click "Save Location" to store the location in the database
4. **Load Locations**: Click "Load Locations" to view all saved locations for the user

### Mobile Usage
The interface is optimized for mobile devices. Simply open the map URL on your phone's browser:
- Enable location services on your device
- Allow browser location permissions
- Follow the same steps as desktop usage

## API Endpoints

### Save Location
**POST** `/advance/v1/location`
```json
{
  "latitude": 4.6097,
  "longitude": -74.0817,
  "userId": 1,
  "timestamp": "2025-11-22T04:00:00"
}
```

**Response:** 201 Created
```json
{
  "id": 1,
  "latitude": 4.6097,
  "longitude": -74.0817,
  "userId": 1,
  "userName": "John Doe",
  "timestamp": "2025-11-22T04:00:00"
}
```

### Get User Locations
**GET** `/advance/v1/location/{userId}`

**Response:** 200 OK
```json
[
  {
    "id": 1,
    "latitude": 4.6097,
    "longitude": -74.0817,
    "userId": 1,
    "userName": "John Doe",
    "timestamp": "2025-11-22T04:00:00"
  }
]
```

### Get Latest Location
**GET** `/advance/v1/location/{userId}/latest`

**Response:** 200 OK
```json
{
  "id": 1,
  "latitude": 4.6097,
  "longitude": -74.0817,
  "userId": 1,
  "userName": "John Doe",
  "timestamp": "2025-11-22T04:00:00"
}
```

## Database Schema

A new table `tr_locations` is automatically created with the following structure:
- `id` (INTEGER, PRIMARY KEY, AUTO INCREMENT)
- `latitude` (DOUBLE)
- `longitude` (DOUBLE)
- `timestamp` (TIMESTAMP)
- `user_id` (INTEGER, FOREIGN KEY to ma_users)

## Technology Stack
- **Backend**: Spring Boot, Spring Data JPA
- **Frontend**: HTML5, CSS3, JavaScript (ES6+)
- **Map Library**: Leaflet.js 1.9.4
- **Map Tiles**: OpenStreetMap
- **Geolocation**: HTML5 Geolocation API

## Browser Compatibility
- Chrome (recommended)
- Firefox
- Safari
- Edge
- Mobile browsers (iOS Safari, Chrome Mobile, Samsung Internet)

**Note:** HTTPS is required for Geolocation API to work in production environments.

## Security Considerations
1. Users must grant location permissions
2. Location data is associated with user IDs
3. Consider adding authentication to restrict access
4. HTTPS should be enabled in production
5. Implement rate limiting for API endpoints

## Future Enhancements
- Real-time location updates using WebSockets
- Location sharing between users
- Geofencing capabilities
- Route tracking and playback
- Location-based notifications
