package co.com.advence.advance.v1.controller.transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.advence.advance.v1.model.Location;
import co.com.advence.advance.v1.service.interfaces.LocationService;

@RestController
@RequestMapping(path="/v1")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@PostMapping(
			path="/location",
			produces="application/json",
			consumes="application/json")
	public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
		Location saved = locationService.save(location);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	@GetMapping(
			path="/location/{userId}",
			produces="application/json")
	public ResponseEntity<List<Location>> getLocationsByUserId(@PathVariable Integer userId) {
		List<Location> locations = locationService.getByUserId(userId);
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}
	
	@GetMapping(
			path="/location/{userId}/latest",
			produces="application/json")
	public ResponseEntity<Location> getLatestLocationByUserId(@PathVariable Integer userId) {
		Location location = locationService.getLatestByUserId(userId);
		if (location == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(location, HttpStatus.OK);
	}
}
