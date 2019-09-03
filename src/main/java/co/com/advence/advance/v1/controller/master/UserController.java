package co.com.advence.advance.v1.controller.master;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.advence.advance.v1.business.UserBusiness;
import co.com.advence.advance.v1.model.User;

@RestController
@RequestMapping(path="/v1")
public class UserController implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private UserBusiness userBisiness;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@GetMapping(
            path="/user",
            produces="application/json")
	public List<User> getUser(final HttpServletRequest request) {
		return userBisiness.getUsers();
	}
	
}
