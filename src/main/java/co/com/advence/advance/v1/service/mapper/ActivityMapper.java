package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.ActivityEntity;
import co.com.advence.advance.v1.model.Activity;

public class ActivityMapper {

	private ActivityMapper() {}
	
	public static ActivityEntity getActivity(Activity activity) {
		ActivityEntity activityEntity = new ActivityEntity();
		activityEntity.setId(activity.getId());
		activityEntity.setName(activity.getName());
		activityEntity.setDescription(activity.getDescription());
		activityEntity.setDeleted(activity.getDeleted());
		return activityEntity;
	}
	
	public static Activity getActivity(ActivityEntity activityEntity) {
		return new Activity.Builder(activityEntity.getId())
				.name(activityEntity.getName())
				.description(activityEntity.getDescription())
				.deleted(activityEntity.getDeleted())
				.build();
	}
	
	public static List<Activity> getActivity(List<ActivityEntity> activitiesEntity) {
		return activitiesEntity.stream().map(
				activityEntity -> 
					getActivity(activityEntity)
				).collect(Collectors.toList());
	}
	
}
