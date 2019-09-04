package co.com.advence.advance.v1.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static class Builder {
		private Integer id;
		private String name;
		private String username;
		private String password;
		private String identification;
		private Role role;
		private Boolean deleted;
		
		public Builder(Integer id) {
			this.id = id;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder username(String username) {
			this.username = username;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder identification(String identification) {
			this.identification = identification;
			return this;
		}
		
		public Builder role(Role role) {
			this.role = role;
			return this;
		}
		
		public Builder deleted(Boolean deleted) {
			this.deleted = deleted;
			return this;
		}
		
		public User build() {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			user.setIdentification(identification);
			user.setRole(role);
			user.setDeleted(deleted);
			return user;
		}
		
	}
	
	private User() {
		
	}
	
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String identification;
	private Role role;
	@JsonIgnore
	private Boolean deleted;
}
