package co.com.advence.advance.v1.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.advence.advance.v1.model.Role;
import co.com.advence.advance.v1.service.interfaces.RoleService;
import co.com.advence.advance.v1.util.JsonUtil;

@RestController
@RequestMapping(path="/v1")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@SuppressWarnings("unchecked")
	@GetMapping(
            path="/role",
            produces="application/json")
	public List<Role> getRoles() {
		return (List<Role>) JsonUtil.jsonExclude(roleService.get(), Role.class, "pages").returnValue();
	}
	
	@GetMapping(
            path="/role/{id}",
            produces="application/json")
	public Role getRole(@PathVariable Integer id) {
		Role role = roleService.get(id);
		if (null != role) {
			role = (Role) JsonUtil.jsonExclude(role, Role.class, "pages").returnValue();
		}
		return role;
	}
	
}
