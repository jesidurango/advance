package co.com.advence.advance.v1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.advence.advance.v1.entity.ProjectEntity;

public interface ProjectDao extends JpaRepository<ProjectEntity, Integer> {

	List<ProjectEntity> findByDeleted(Boolean deleted);
	
	Optional<ProjectEntity> findByIdAndDeleted(Integer is, Boolean deleted);
	
}
