package co.com.advence.advance.v1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.advence.advance.v1.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

}
