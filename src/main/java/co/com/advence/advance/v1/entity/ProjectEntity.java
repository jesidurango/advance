package co.com.advence.advance.v1.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ma_projects")
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "finish_date")
	private Date finishDate;
	private String code;
	private String description;
	private Boolean deleted;
	
	@ManyToOne
	@JoinColumn(name="create_by")
	private UserEntity createBy;
	
	@ManyToMany(mappedBy = "projects")
	private List<UserEntity> usersByProject;
	
	@ManyToMany
	@JoinTable(
			name = "tr_activities_projects", 
			joinColumns = @JoinColumn(name = "project_id"), 
			inverseJoinColumns = @JoinColumn(name = "activity_id"))
	private List<ActivityEntity> activities;
	
}
