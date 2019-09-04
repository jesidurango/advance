package co.com.advence.advance.v1.service.interfaces;

import java.util.List;

import co.com.advence.advance.v1.model.Project;

public interface ProjectService {

	Project save(Project project);
	
	List<Project> getProject();
	
	Project getProject(Integer id);
	
}
