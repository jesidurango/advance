package co.com.advence.advance.v1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.advence.advance.v1.entity.RoleEntity;

public interface RoleDao extends JpaRepository<RoleEntity, Integer> {

}
