package co.com.advence.advance.v1.service.interfaces;

import java.util.List;

import co.com.advence.advance.v1.model.Project;

public interface ProjectService {

	Project save(Project project);
	
	boolean delete(Integer id);
	
	boolean update(Project project);
	
	List<Project> get();
	
	List<Project> getByUser(Integer userId);
	
	Project get(Integer id);
	
	
	
}
