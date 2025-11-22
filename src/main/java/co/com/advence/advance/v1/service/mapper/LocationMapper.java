package co.com.advence.advance.v1.service.mapper;

import java.util.ArrayList;
import java.util.List;

import co.com.advence.advance.v1.entity.LocationEntity;
import co.com.advence.advance.v1.entity.UserEntity;
import co.com.advence.advance.v1.model.Location;

public class LocationMapper {

	public static Location mapEntityToModel(LocationEntity entity) {
		if (entity == null) {
			return null;
		}
		
		Location.Builder builder = new Location.Builder(entity.getId())
			.latitude(entity.getLatitude())
			.longitude(entity.getLongitude())
			.timestamp(entity.getTimestamp());
		
		if (entity.getUser() != null) {
			builder.userId(entity.getUser().getId())
				.userName(entity.getUser().getName());
		}
		
		return builder.build();
	}
	
	public static LocationEntity mapModelToEntity(Location model) {
		if (model == null) {
			return null;
		}
		
		LocationEntity entity = new LocationEntity();
		entity.setId(model.getId());
		entity.setLatitude(model.getLatitude());
		entity.setLongitude(model.getLongitude());
		entity.setTimestamp(model.getTimestamp());
		
		if (model.getUserId() != null) {
			UserEntity user = new UserEntity(model.getUserId());
			entity.setUser(user);
		}
		
		return entity;
	}
	
	public static List<Location> mapEntityListToModelList(List<LocationEntity> entities) {
		List<Location> models = new ArrayList<>();
		if (entities != null) {
			for (LocationEntity entity : entities) {
				models.add(mapEntityToModel(entity));
			}
		}
		return models;
	}
}
