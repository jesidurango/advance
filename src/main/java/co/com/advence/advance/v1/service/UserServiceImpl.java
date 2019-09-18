package co.com.advence.advance.v1.service;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Optional;

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
    public UserDetails loadUserByUsername(String username) {
        UserEntity applicationUser = userDao.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
	
	public List<User> get() {
		return UserMapper.getUser(userDao.findByDeleted(false));
	}
	
	public User get(Integer id) {
		Optional<UserEntity> result = userDao.findByIdAndDeleted(id, false);
		User user = null;
		if (result.isPresent()) {
			user = UserMapper.getUser(result.get());
		}
		return user;
	}
	
	public void singUp(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setDeleted(false);
		UserEntity userEntity = UserMapper.getUser(user);
		userDao.save(userEntity);
	}
	
}
