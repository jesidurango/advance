package co.com.advence.advance.v1.controller.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.advence.advance.v1.model.Menu;
import co.com.advence.advance.v1.service.interfaces.RoleService;

@RestController
@RequestMapping(path="/v1")
public class MenuController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping(
            path="/menu/{roleId}",
            produces="application/json")
	public Menu getMenu(@PathVariable Integer roleId) {
		return roleService.getMenuByRole(roleId);
	}
	
}
