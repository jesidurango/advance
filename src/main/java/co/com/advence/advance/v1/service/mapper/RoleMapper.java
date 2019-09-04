package co.com.advence.advance.v1.service.mapper;

import co.com.advence.advance.v1.entity.RoleEntity;
import co.com.advence.advance.v1.model.Role;

public class RoleMapper {

	public static Role getRole(RoleEntity roleEntity) {
		Role role = new Role.Builder(roleEntity.getId())
				.name(roleEntity.getName())
				.deleted(roleEntity.getDeleted())
				.pages(PageMapper.getPage(roleEntity.getPagesByRole()))
				.build();
		return role;
	}
	
}
