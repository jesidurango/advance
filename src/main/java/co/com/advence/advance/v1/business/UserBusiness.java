package co.com.advence.advance.v1.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.advence.advance.v1.business.mapper.UserMapper;
import co.com.advence.advance.v1.dao.UserDao;
import co.com.advence.advance.v1.model.User;

@Service
public class UserBusiness {

	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers() {
		return UserMapper.getUser(userDao.findAll());
	}
	
}
