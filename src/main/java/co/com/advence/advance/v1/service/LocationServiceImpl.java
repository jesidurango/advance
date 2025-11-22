package co.com.advence.advance.v1.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.advence.advance.v1.dao.LocationDao;
import co.com.advence.advance.v1.entity.LocationEntity;
import co.com.advence.advance.v1.model.Location;
import co.com.advence.advance.v1.service.interfaces.LocationService;
import co.com.advence.advance.v1.service.mapper.LocationMapper;

public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;

	@Override
	public Location save(Location location) {
		LocalDateTime timestamp = location.getTimestamp() != null ? location.getTimestamp() : LocalDateTime.now();
		Location locationWithTimestamp = new Location.Builder(location.getId())
			.latitude(location.getLatitude())
			.longitude(location.getLongitude())
			.timestamp(timestamp)
			.userId(location.getUserId())
			.userName(location.getUserName())
			.build();
		
		LocationEntity entity = LocationMapper.mapModelToEntity(locationWithTimestamp);
		LocationEntity saved = locationDao.save(entity);
		return LocationMapper.mapEntityToModel(saved);
	}

	@Override
	public List<Location> getByUserId(Integer userId) {
		List<LocationEntity> entities = locationDao.findByUserId(userId);
		return LocationMapper.mapEntityListToModelList(entities);
	}

	@Override
	public Location getLatestByUserId(Integer userId) {
		LocationEntity entity = locationDao.findFirstByUserIdOrderByTimestampDesc(userId);
		return LocationMapper.mapEntityToModel(entity);
	}
}
