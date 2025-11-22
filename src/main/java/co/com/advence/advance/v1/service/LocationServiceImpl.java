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
		if (location.getTimestamp() == null) {
			location.setTimestamp(LocalDateTime.now());
		}
		LocationEntity entity = LocationMapper.mapModelToEntity(location);
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
		LocationEntity entity = locationDao.findLatestByUserId(userId);
		return LocationMapper.mapEntityToModel(entity);
	}
}
