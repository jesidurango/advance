package co.com.advence.advance.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.advence.advance.v1.dao.ActivityDao;
import co.com.advence.advance.v1.entity.ActivityEntity;
import co.com.advence.advance.v1.model.Activity;
import co.com.advence.advance.v1.service.interfaces.ActivityService;
import co.com.advence.advance.v1.service.mapper.ActivityMapper;

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public Activity save(Activity activity) {
		ActivityEntity activityEntity = ActivityMapper.getActivity(activity);
		activityEntity.setDeleted(false);
		activityDao.save(activityEntity);
		activity.setId(activityEntity.getId());
		return activity;
	}

	@Override
	public List<Activity> get() {
		return ActivityMapper.getActivity(activityDao.findByDeleted(false));
	}

	@Override
	public Activity get(Integer id) {
		Activity activity = null;
		Optional<ActivityEntity> result = activityDao.findByIdAndDeleted(id, false);
		
		if (result.isPresent()) {
			activity = ActivityMapper.getActivity(result.get());
		}
		return activity;
	}

	@Override
	public boolean delete(Integer id) {
		Activity activity = get(id);
		activity.setDeleted(true);
		save(activity);
		return true;
	}

}
