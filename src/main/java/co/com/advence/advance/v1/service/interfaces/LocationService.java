package co.com.advence.advance.v1.service.interfaces;

import java.util.List;

import co.com.advence.advance.v1.model.Location;

public interface LocationService {

	Location save(Location location);
	
	List<Location> getByUserId(Integer userId);
	
	Location getLatestByUserId(Integer userId);
}
