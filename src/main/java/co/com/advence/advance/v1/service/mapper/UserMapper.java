package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.RoleEntity;
import co.com.advence.advance.v1.entity.UserEntity;
import co.com.advence.advance.v1.model.User;

public class UserMapper {

	private UserMapper() {}
	
	public static User getUser(UserEntity userEntity) {
		return new User.Builder(userEntity.getId())
				.name(userEntity.getName())
				.identification(userEntity.getIdentification())
				.username(userEntity.getUsername())
				.role(RoleMapper.getRole(userEntity.getRole()))
				.password(userEntity.getPassword())
				.build();
	}
	
	public static UserEntity getUser(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(user.getId());
		userEntity.setDeleted(user.getDeleted());
		userEntity.setIdentification(user.getIdentification());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setUsername(user.getUsername());
		if (null != user.getRole()) {
			RoleEntity roleEntity = new RoleEntity();
			roleEntity.setId(user.getRole().getId());
			roleEntity.setName(user.getRole().getName());
			userEntity.setRole(roleEntity);
		}
		userEntity.setDeleted(user.getDeleted());
		return userEntity;
	}
	
	public static List<User> getUser(List<UserEntity> userEntities) {
		return userEntities.stream().map(
				UserMapper::getUser
				).collect(Collectors.toList());
	}
	
	
}
