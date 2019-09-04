package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.ProjectEntity;
import co.com.advence.advance.v1.model.Project;

public class ProjectMapper {

	public static Project getProject(ProjectEntity projectEntity) {
		Project project = new Project.Builder(projectEntity.getId())
				.code(projectEntity.getCode())
				.deleted(projectEntity.getDeleted())
				.description(projectEntity.getDescription())
				.finishDate(projectEntity.getFinishDate())
				.name(projectEntity.getName())
				.startDate(projectEntity.getStartDate())
				.createdBy(UserMapper.getUser(projectEntity.getCreateBy()))
				.build();
		return project;
	}
	
	public static List<Project> getProject(List<ProjectEntity> projectsEntity) {
		List<Project> list = projectsEntity.stream().map(
				project -> 
					getProject(project)
				).collect(Collectors.toList());
		return list;
	}
	
	public static ProjectEntity getProject(Project project) {
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setCode(project.getCode());
		projectEntity.setCreateBy(UserMapper.getUser(project.getCreatedBy()));
		projectEntity.setDeleted(project.getDeleted());
		projectEntity.setDescription(project.getDescription());
		projectEntity.setFinishDate(project.getFinishDate());
		projectEntity.setId(project.getId());
		projectEntity.setName(project.getName());
		projectEntity.setStartDate(project.getStartDate());
		return projectEntity;
	}
	
}
