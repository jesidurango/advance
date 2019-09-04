package co.com.advence.advance.v1.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ma_pages")
public class PageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String url;
	private Integer father;
	private Integer order;
	
	@ManyToMany(mappedBy = "pagesByRole")
	private List<RoleEntity> rolesByPage;
	
}
