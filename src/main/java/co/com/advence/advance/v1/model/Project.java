package co.com.advence.advance.v1.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static class Builder {
		private Integer id;
		private String name;
		private Date startDate;
		private Date finishDate;
		private String code;
		private String description;
		private Boolean deleted;
		
		private User createdBy;
		
		public Builder(Integer id) {
			this.id = id;
		}
		
		public Builder() {}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder startDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}
		
		public Builder finishDate(Date finishDate) {
			this.finishDate = finishDate;
			return this;
		}
		
		public Builder code(String code) {
			this.code = code;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder deleted(Boolean deleted) {
			this.deleted = deleted;
			return this;
		}
		
		public Builder createdBy(User createdBy) {
			this.createdBy = createdBy;
			return this;
		}
		
		public Project build() {
			Project project = new Project();
			project.setCode(code);
			project.setDeleted(deleted);
			project.setDescription(description);
			project.setFinishDate(finishDate);
			project.setId(id);
			project.setName(name);
			project.setStartDate(startDate);
			project.setCreatedBy(createdBy);
			return project;
		}
	}
	
	private Project() {}
	
	private Integer id;
	private String name;
	private Date startDate;
	private Date finishDate;
	private String code;
	private String description;
	private Boolean deleted;
	
	private User createdBy;

}
