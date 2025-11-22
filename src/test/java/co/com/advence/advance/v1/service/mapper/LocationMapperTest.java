package co.com.advence.advance.v1.service.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.com.advence.advance.v1.entity.LocationEntity;
import co.com.advence.advance.v1.entity.UserEntity;
import co.com.advence.advance.v1.model.Location;

public class LocationMapperTest {

    @Test
    public void testMapEntityToModel() {
        // Arrange
        UserEntity user = new UserEntity(1);
        user.setName("Test User");
        
        LocationEntity entity = new LocationEntity();
        entity.setId(1);
        entity.setLatitude(4.6097);
        entity.setLongitude(-74.0817);
        entity.setTimestamp(LocalDateTime.now());
        entity.setUser(user);
        
        // Act
        Location model = LocationMapper.mapEntityToModel(entity);
        
        // Assert
        Assert.assertNotNull(model);
        Assert.assertEquals(entity.getId(), model.getId());
        Assert.assertEquals(entity.getLatitude(), model.getLatitude());
        Assert.assertEquals(entity.getLongitude(), model.getLongitude());
        Assert.assertEquals(entity.getTimestamp(), model.getTimestamp());
        Assert.assertEquals(user.getId(), model.getUserId());
        Assert.assertEquals(user.getName(), model.getUserName());
    }

    @Test
    public void testMapModelToEntity() {
        // Arrange
        Location model = new Location.Builder(1)
            .latitude(4.6097)
            .longitude(-74.0817)
            .timestamp(LocalDateTime.now())
            .userId(1)
            .userName("Test User")
            .build();
        
        // Act
        LocationEntity entity = LocationMapper.mapModelToEntity(model);
        
        // Assert
        Assert.assertNotNull(entity);
        Assert.assertEquals(model.getId(), entity.getId());
        Assert.assertEquals(model.getLatitude(), entity.getLatitude());
        Assert.assertEquals(model.getLongitude(), entity.getLongitude());
        Assert.assertEquals(model.getTimestamp(), entity.getTimestamp());
        Assert.assertEquals(model.getUserId(), entity.getUser().getId());
    }

    @Test
    public void testMapEntityListToModelList() {
        // Arrange
        List<LocationEntity> entities = new ArrayList<>();
        
        UserEntity user = new UserEntity(1);
        user.setName("Test User");
        
        LocationEntity entity1 = new LocationEntity();
        entity1.setId(1);
        entity1.setLatitude(4.6097);
        entity1.setLongitude(-74.0817);
        entity1.setTimestamp(LocalDateTime.now());
        entity1.setUser(user);
        
        LocationEntity entity2 = new LocationEntity();
        entity2.setId(2);
        entity2.setLatitude(4.6100);
        entity2.setLongitude(-74.0820);
        entity2.setTimestamp(LocalDateTime.now());
        entity2.setUser(user);
        
        entities.add(entity1);
        entities.add(entity2);
        
        // Act
        List<Location> models = LocationMapper.mapEntityListToModelList(entities);
        
        // Assert
        Assert.assertNotNull(models);
        Assert.assertEquals(2, models.size());
        Assert.assertEquals(entity1.getId(), models.get(0).getId());
        Assert.assertEquals(entity2.getId(), models.get(1).getId());
    }

    @Test
    public void testMapEntityToModelWithNullEntity() {
        // Act
        Location model = LocationMapper.mapEntityToModel(null);
        
        // Assert
        Assert.assertNull(model);
    }

    @Test
    public void testMapModelToEntityWithNullModel() {
        // Act
        LocationEntity entity = LocationMapper.mapModelToEntity(null);
        
        // Assert
        Assert.assertNull(entity);
    }
}
