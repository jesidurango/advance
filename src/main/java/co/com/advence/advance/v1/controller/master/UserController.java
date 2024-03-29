package co.com.advence.advance.v1.controller.master;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.model.User;
import co.com.advence.advance.v1.service.UserServiceImpl;
import co.com.advence.advance.v1.service.interfaces.ProjectService;
import co.com.advence.advance.v1.util.JsonUtil;

@RestController
@RequestMapping(path="/v1")
public class UserController {

	@Autowired
	private UserServiceImpl userBisiness;
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/user/sign-up")
    public void signUp(@RequestBody User user) {
        userBisiness.singUp(user);
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping(
            path="/user",
            produces="application/json")
	public List<User> getUsers(final HttpServletRequest request) {
		return (List<User>) JsonUtil.jsonExclude(userBisiness.get(), User.class, "password", "role.pages").returnValue();
	}
	
	@GetMapping(
            path="/user/{id}",
            produces="application/json")
	public User getUser(@PathVariable Integer id) {
		User user = userBisiness.get(id);
		if (null != user) {
			user = (User) JsonUtil.jsonExclude(userBisiness.get(id), User.class, "password", "role.pages").returnValue();
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(
            path="/user/{id}/project",
            produces="application/json")
	public List<Project> getProjectsByUser(@PathVariable Integer id) {
		List<Project> projects = projectService.getByUser(id);
		if (null != projects && !projects.isEmpty()) {
			projects = (List<Project>) JsonUtil.jsonExclude(projects, Project.class, "createdBy").returnValue();
		}
		return projects;
	}
	
}
