package co.com.advence.advance.v1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.advence.advance.v1.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username);
	
	List<UserEntity> findByDeleted(Boolean deleted);
	
	Optional<UserEntity> findByIdAndDeleted(Integer id, Boolean deleted);
	
}
