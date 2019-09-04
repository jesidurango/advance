package co.com.advence.advance.v1.service.interfaces;

import java.util.List;

import co.com.advence.advance.v1.model.Menu;
import co.com.advence.advance.v1.model.Role;

public interface RoleService {

	Menu getMenuByRole(Integer id);
	
	List<Role> get();
	
	Role get(Integer id);
	
}
