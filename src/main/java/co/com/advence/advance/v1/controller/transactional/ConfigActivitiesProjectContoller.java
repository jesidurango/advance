package co.com.advence.advance.v1.controller.transactional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.advence.advance.v1.model.ActivityProject;
import co.com.advence.advance.v1.service.interfaces.ProjectService;

@RestController
@RequestMapping(path="/v1")
public class ConfigActivitiesProjectContoller {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping(path = "/activity/project", produces = "application/json")
	public ResponseEntity<String> save(@RequestBody @Valid ActivityProject activityProject) {
		return ResponseEntity.ok().body(
				projectService.saveActivityByProject(activityProject));
	}
	
}
