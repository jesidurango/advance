package co.com.advence.advance.v1.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static class Builder {
		private Integer id;
		private String name;
		private Boolean deleted;
		private List<Page> pages;
		
		public Builder(Integer id) {
			this.id = id;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder deleted(Boolean deleted) {
			this.deleted = deleted;
			return this;
		}
		
		public Builder pages(List<Page> pages) {
			this.pages = pages;
			return this;
		}
		
		public Role build() {
			Role role = new Role();
			role.setId(id);
			role.setName(name);
			role.setDeleted(deleted);
			role.setPages(pages);
			return role;
		}
		
	}
	
	private Role() {}
	
	private Integer id;
	private String name;
	private Boolean deleted;
	
	private List<Page> pages;
}
