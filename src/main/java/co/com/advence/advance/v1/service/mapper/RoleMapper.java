package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.RoleEntity;
import co.com.advence.advance.v1.model.Role;

public class RoleMapper {

	private RoleMapper() {}
	
	public static Role getRole(RoleEntity roleEntity) {
		return new Role.Builder(roleEntity.getId())
				.name(roleEntity.getName())
				.deleted(roleEntity.getDeleted())
				.pages(PageMapper.getPage(roleEntity.getPagesByRole()))
				.build();
	}
	
	public static List<Role> getRole(List<RoleEntity> rolesEntity) {
		return rolesEntity.stream().map(
				RoleMapper::getRole
				).collect(Collectors.toList());
	}
	
}
