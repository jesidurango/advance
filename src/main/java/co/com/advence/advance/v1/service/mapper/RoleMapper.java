package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<Role> getRole(List<RoleEntity> rolesEntity) {
		List<Role> list = rolesEntity.stream().map(
				role ->
					getRole(role)
				).collect(Collectors.toList());
		return list;
	}
	
}
