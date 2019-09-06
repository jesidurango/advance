package co.com.advence.advance.v1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.advence.advance.v1.entity.ActivityEntity;

public interface ActivityDao extends JpaRepository<ActivityEntity, Integer> {

	List<ActivityEntity> findByDeleted(Boolean deleted);
	
	Optional<ActivityEntity> findByIdAndDeleted(Integer id, Boolean deleted);
	
}
