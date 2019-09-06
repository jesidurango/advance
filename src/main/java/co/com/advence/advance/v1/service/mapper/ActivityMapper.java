package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.ActivityEntity;
import co.com.advence.advance.v1.model.Activity;

public class ActivityMapper {

	public static ActivityEntity getActivity(Activity activity) {
		ActivityEntity activityEntity = new ActivityEntity();
		activityEntity.setId(activity.getId());
		activityEntity.setName(activity.getName());
		activityEntity.setDescription(activity.getDescription());
		return activityEntity;
	}
	
	public static Activity getActivity(ActivityEntity activityEntity) {
		Activity activity = new Activity.Builder(activityEntity.getId())
				.name(activityEntity.getName())
				.description(activityEntity.getDescription())
				.build();
		return activity;
	}
	
	public static List<Activity> getActivity(List<ActivityEntity> activitiesEntity) {
		List<Activity> list = activitiesEntity.stream().map(
				activityEntity -> 
					getActivity(activityEntity)
				).collect(Collectors.toList());
		return list;
	}
	
}
