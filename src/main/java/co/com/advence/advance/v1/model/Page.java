package co.com.advence.advance.v1.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static class Builder {
		private Integer id;
		private String name;
		private String url;
		private Integer father;
		private Integer order;
		
		public Builder(Integer id) {
			this.id = id;
		}
		
		public Builder() {}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder url(String url) {
			this.url = url;
			return this;
		}
		
		public Builder father(Integer father) {
			this.father = father;
			return this;
		}
		
		public Builder order(Integer order) {
			this.order = order;
			return this;
		}
		
		public Page build() {
			Page page = new Page();
			page.setId(id);
			page.setName(name);
			page.setUrl(url);
			page.setFather(father);
			page.setOrder(order);
			return page;
		}
		
	}
	
	private Page() {}
	
	private Integer id;
	private String name;
	private String url;
	private Integer father;
	private Integer order;
	
}
