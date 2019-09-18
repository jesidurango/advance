package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.ProjectEntity;
import co.com.advence.advance.v1.model.Project;

public class ProjectMapper {
	
	private ProjectMapper() {}

	public static Project getProject(ProjectEntity projectEntity) {
		return new Project.Builder(projectEntity.getId())
				.code(projectEntity.getCode())
				.deleted(projectEntity.getDeleted())
				.description(projectEntity.getDescription())
				.finishDate(projectEntity.getFinishDate())
				.name(projectEntity.getName())
				.startDate(projectEntity.getStartDate())
				.address(projectEntity.getAddress())
				.createdBy(UserMapper.getUser(projectEntity.getCreateBy()))
				.build();
	}
	
	public static List<Project> getProject(List<ProjectEntity> projectsEntity) {
		return projectsEntity.stream().map(
				ProjectMapper::getProject
				).collect(Collectors.toList());
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
		projectEntity.setAddress(project.getAddress());
		return projectEntity;
	}
	
}
