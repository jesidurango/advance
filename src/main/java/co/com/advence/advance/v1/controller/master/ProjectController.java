package co.com.advence.advance.v1.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.service.interfaces.ProjectService;
import co.com.advence.advance.v1.util.JsonUtil;

@RestController
@RequestMapping(path="/v1")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping(path = "/project", produces = "application/json")
	public Project save(@RequestBody Project project) throws JsonProcessingException {
		return (Project) JsonUtil.jsonExclude(
				projectService.save(project), 
				Project.class, 
				"createdBy.role",
				"createdBy.name",
				"createdBy.username",
				"createdBy.identification").returnValue();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(path = "/project", produces = "application/json")
	public List<Project> getProjects() throws JsonProcessingException {
		List<Project> list = projectService.get();
		if (null != list && !list.isEmpty()) {
			list = (List<Project>) JsonUtil.jsonExclude(
					list, 
					Project.class,
					"createdBy.role",
					"createdBy.name",
					"createdBy.username",
					"createdBy.identification").returnValue();
		}
		return list;
	}
	
	@GetMapping(path = "/project/{id}", produces = "application/json")
	public Project getProject(@PathVariable Integer id) throws JsonProcessingException {
		Project project = projectService.get(id);
		if (null != project) {
			project = (Project) JsonUtil.jsonExclude(
					project, 
					Project.class,
					"createdBy.role",
					"createdBy.name",
					"createdBy.username",
					"createdBy.identification").returnValue();
		}
		return project;
	}
	
	@DeleteMapping("/project/{id}")
	public void delete(@PathVariable Integer id) {
		projectService.delete(id);
	}
	
}
