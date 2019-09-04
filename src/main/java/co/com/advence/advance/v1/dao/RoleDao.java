package co.com.advence.advance.v1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.advence.advance.v1.entity.RoleEntity;

public interface RoleDao extends JpaRepository<RoleEntity, Integer> {

	List<RoleEntity> findByDeleted(Boolean deleted);
	
}
