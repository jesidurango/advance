package co.com.advence.advance.v1.service.interfaces;

import java.util.List;

import co.com.advence.advance.v1.model.Activity;

public interface ActivityService {

	Activity save(Activity activity);
	
	List<Activity> get();
	
	Activity get(Integer id);
	
	boolean delete(Integer id);
	
	boolean update(Activity project);
	
}
