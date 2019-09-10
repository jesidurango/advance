package co.com.advence.advance.v1.service.interfaces;

import java.util.List;

import co.com.advence.advance.v1.model.ActivityProject;
import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.model.UserProject;

public interface ProjectService {

	Project save(Project project);
	
	boolean delete(Integer id);
	
	boolean update(Project project);
	
	String saveUsersByProject(UserProject userProject);
	
	String saveActivityByProject(ActivityProject activityProject);
	
	List<Project> get();
	
	List<Project> getByUser(Integer userId);
	
	Project get(Integer id);
	
	
	
}
