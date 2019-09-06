package co.com.advence.advance.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.advence.advance.v1.dao.ProjectDao;
import co.com.advence.advance.v1.dao.UserDao;
import co.com.advence.advance.v1.entity.ProjectEntity;
import co.com.advence.advance.v1.entity.UserEntity;
import co.com.advence.advance.v1.model.Project;
import co.com.advence.advance.v1.service.interfaces.ProjectService;
import co.com.advence.advance.v1.service.mapper.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Project save(Project project) {
		ProjectEntity projectEntity = ProjectMapper.getProject(project);
		projectEntity.setDeleted(false);
		projectDao.save(projectEntity);
		project.setId(projectEntity.getId());
		return project;
	}

	@Override
	public boolean delete(Integer id) {
		Project project = get(id);
		project.setDeleted(true);
		save(project);
		return true;
	}
	
	@Override
	public List<Project> get() {
		return ProjectMapper.getProject(projectDao.findByDeleted(false));
	}

	@Override
	public Project get(Integer id) {
		Optional<ProjectEntity> result = projectDao.findByIdAndDeleted(id, false);
		Project project = null;
		if (result.isPresent()) {
			project = ProjectMapper.getProject(result.get());
		}
		return project;
	}

	@Override
	public boolean update(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Project> getByUser(Integer userId) {
		Optional<UserEntity> result = userDao.findByIdAndDeleted(userId, false);
		List<Project> projects = null;
		if (result.isPresent()) {
			if (null != result.get().getProjects() && !result.get().getProjects().isEmpty()) {
				projects = ProjectMapper.getProject(result.get().getProjects());
			}
		}
		return projects;
	}
	
}
