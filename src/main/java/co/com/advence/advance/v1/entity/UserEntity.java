package co.com.advence.advance.v1.entity;

import java.util.List;

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
@Table(name="ma_users")
public class UserEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String username;
	private String password;
	private String identification;
	private Boolean deleted;
	
	@ManyToOne
	@JoinColumn(name="id_role")
	private RoleEntity role;
	
	@ManyToMany
	@JoinTable(
			name = "tr_users_projects", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<ProjectEntity> projects;
	
	public UserEntity() {}
	
	public UserEntity(Integer id) {
		this.id = id;
	}
	
}
