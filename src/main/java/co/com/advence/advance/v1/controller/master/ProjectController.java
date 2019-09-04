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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.JsonViewModule;
import com.monitorjbl.json.Match;

import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.service.interfaces.ProjectService;

@RestController
@RequestMapping(path="/v1")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	private String JsonExclude(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
		String json = mapper.writeValueAsString(
				JsonView.with(object).onClass(
						Project.class, Match.match().exclude(
								"createdBy.role",
								"createdBy.name",
								"createdBy.username",
								"createdBy.identification"
								)
						)
				);
		return json;
	}
	
	@PostMapping(path = "/project", produces = "application/json")
	public String save(@RequestBody Project project) throws JsonProcessingException {
		return JsonExclude(projectService.save(project));
	}
	
	@GetMapping(path = "/project", produces = "application/json")
	public String getProjects() throws JsonProcessingException {
		List<Project> list = projectService.getProject();
		String json = JsonExclude(list);
		return json;
	}
	
	@GetMapping(path = "/project/{id}", produces = "application/json")
	public String getProject(@PathVariable Integer id) throws JsonProcessingException {
		String json = JsonExclude(projectService.getProject(id));
		return json;
	}
	
	@DeleteMapping("/project/{id}")
	public void delete(@PathVariable Integer id) {
		projectService.delete(id);
	}
	
}
