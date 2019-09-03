package co.com.advence.advance.v1.controller.master;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.advence.advance.v1.model.User;
import co.com.advence.advance.v1.service.UserServiceImpl;

@RestController
@RequestMapping(path="/v1")
public class UserController implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private UserServiceImpl userBisiness;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@PostMapping("/user/sign-up")
    public void signUp(@RequestBody User user) {
        userBisiness.singUp(user);
    }
	
	@GetMapping(
            path="/user",
            produces="application/json")
	public List<User> getUser(final HttpServletRequest request) {
		return userBisiness.getUsers();
	}
	
}
