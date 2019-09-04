package co.com.advence.advance.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.advence.advance.v1.dao.ProjectDao;
import co.com.advence.advance.v1.entity.ProjectEntity;
import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.service.interfaces.ProjectService;
import co.com.advence.advance.v1.service.mapper.ProjectMapper;

public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Override
	public Project save(Project project) {
		ProjectEntity projectEntity = ProjectMapper.getProject(project);
		projectEntity = projectDao.save(projectEntity);
		project = ProjectMapper.getProject(projectEntity);
		return project;
	}

	@Override
	public List<Project> getProject() {
		return ProjectMapper.getProject(projectDao.findAll());
	}

	@Override
	public Project getProject(Integer id) {
		Optional<ProjectEntity> result = projectDao.findById(id);
		Project project = null;
		if (result.isPresent()) {
			project = ProjectMapper.getProject(result.get());
		}
		return project;
	}
	
}
