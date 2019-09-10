package co.com.advence.advance.v1.controller.transactional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.com.advence.advance.v1.model.UserProject;
import co.com.advence.advance.v1.service.interfaces.ProjectService;

@RestController
@RequestMapping(path="/v1")
public class ConfigUserProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping(path = "/user/project", produces = "application/json")
	public ResponseEntity<String> save(@RequestBody @Valid UserProject userProject) throws JsonProcessingException {
		return ResponseEntity.ok().body(
				projectService.saveUsersByProject(userProject));
	}
	
}
