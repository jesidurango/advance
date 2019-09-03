package co.com.advence.advance.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.advence.advance.v1.dao.UserDao;
import co.com.advence.advance.v1.entity.UserEntity;
import co.com.advence.advance.v1.model.User;
import co.com.advence.advance.v1.service.mapper.UserMapper;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity applicationUser = userDao.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
	
	public List<User> getUsers() {
		return UserMapper.getUser(userDao.findAll());
	}
	
	public void singUp(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setDeleted(false);
		UserEntity userEntity = UserMapper.getUser(user);
		userDao.save(userEntity);
	}
	
}
