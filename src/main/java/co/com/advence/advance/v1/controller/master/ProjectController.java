package co.com.advence.advance.v1.controller.master;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/v1")
public class ProjectController {

	@PostMapping("/project")
	public void save() {
		
	}
	
	@GetMapping("/project")
	public void getProjects() {
		
	}
	
	@GetMapping("/project/{id}")
	public void getProject() {
		
	}
	
}
