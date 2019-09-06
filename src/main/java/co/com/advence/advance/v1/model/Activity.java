package co.com.advence.advance.v1.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static class Builder {
		private Integer id;
		private String name;
		private String description;
		private Boolean deleted;
		
		public Builder(Integer id) {
			this.id = id;
		}
		
		public Builder name(String name) {
			this.name = name;
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
		
		public Activity build() {
			Activity activity = new Activity();
			activity.setId(id);
			activity.setName(name);
			activity.setDescription(description);
			activity.setDeleted(deleted);
			return activity;
		}
	}
	
	private Activity() {}
	
	private Integer id;
	private String name;
	private String description;
	private Boolean deleted;
}
