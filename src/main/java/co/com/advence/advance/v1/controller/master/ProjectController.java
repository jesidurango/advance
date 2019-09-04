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

import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.service.interfaces.ProjectService;

@RestController
@RequestMapping(path="/v1")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/project")
	public Project save(@RequestBody Project project) {
		return projectService.save(project);
	}
	
	@GetMapping("/project")
	public List<Project> getProjects() {
		return projectService.getProject();
	}
	
	@GetMapping("/project/{id}")
	public Project getProject(@PathVariable Integer id) {
		return projectService.getProject(id);
	}
	
	@DeleteMapping("/project/{id}")
	public void delete(@PathVariable Integer id) {
		projectService.delete(id);
	}
	
}
