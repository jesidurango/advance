package co.com.advence.advance.v1.business.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.UserEntity;
import co.com.advence.advance.v1.model.User;

public class UserMapper {

	public static User getUser(UserEntity userEntity) {
		User user = new User.Builder(userEntity.getId())
				.name(userEntity.getName())
				.identification(userEntity.getIdentification())
				.username(userEntity.getUsername())
				.role(RoleMapper.getRole(userEntity.getRole()))
				.build();
		return user;
	}
	
	public static List<User> getUser(List<UserEntity> userEntities) {
		List<User> list = userEntities.stream().map(
				user -> 
					getUser(user)
				).collect(Collectors.toList());
		return list;
	}
	
}
