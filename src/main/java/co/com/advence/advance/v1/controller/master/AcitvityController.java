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

import co.com.advence.advance.v1.model.Activity;
import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.service.interfaces.ActivityService;
import co.com.advence.advance.v1.util.JsonUtil;

@RestController
@RequestMapping(path="/v1")
public class AcitvityController {

	@Autowired
	private ActivityService activityService;
	
	@PostMapping(path = "/activity", produces = "application/json")
	public Activity save(@RequestBody Activity activity) throws JsonProcessingException {
		return (Activity) JsonUtil.jsonExclude(
				activityService.save(activity), 
				Project.class, 
				"deleted").returnValue();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(path = "/activity", produces = "application/json")
	public List<Activity> getProjects() throws JsonProcessingException {
		List<Activity> list = activityService.get();
		if (null != list && !list.isEmpty()) {
			list = (List<Activity>) JsonUtil.jsonExclude(
					list, 
					Project.class,
					"deleted").returnValue();
		}
		return list;
	}
	
	@GetMapping(path = "/activity/{id}", produces = "application/json")
	public Activity getProject(@PathVariable Integer id) throws JsonProcessingException {
		Activity activity = activityService.get(id);
		if (null != activity) {
			activity = (Activity) JsonUtil.jsonExclude(
					activity,
					Project.class,
					"deleted").returnValue();
		}
		return activity;
	}
	
	@DeleteMapping("/activity/{id}")
	public void delete(@PathVariable Integer id) {
		activityService.delete(id);
	}
	
}
