package co.com.advence.advance.v1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.advence.advance.v1.entity.LocationEntity;

public interface LocationDao extends JpaRepository<LocationEntity, Integer> {

	@Query("SELECT l FROM LocationEntity l WHERE l.user.id = :userId ORDER BY l.timestamp DESC")
	List<LocationEntity> findByUserId(@Param("userId") Integer userId);
	
	LocationEntity findFirstByUserIdOrderByTimestampDesc(Integer userId);
}
