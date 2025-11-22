package co.com.advence.advance.v1.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static class Builder {
		private Integer id;
		private Double latitude;
		private Double longitude;
		private LocalDateTime timestamp;
		private Integer userId;
		private String userName;
		
		public Builder(Integer id) {
			this.id = id;
		}
		
		public Builder latitude(Double latitude) {
			this.latitude = latitude;
			return this;
		}
		
		public Builder longitude(Double longitude) {
			this.longitude = longitude;
			return this;
		}
		
		public Builder timestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		public Builder userId(Integer userId) {
			this.userId = userId;
			return this;
		}
		
		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}
		
		public Location build() {
			Location location = new Location();
			location.setId(id);
			location.setLatitude(latitude);
			location.setLongitude(longitude);
			location.setTimestamp(timestamp);
			location.setUserId(userId);
			location.setUserName(userName);
			return location;
		}
	}
	
	private Location() {}
	
	private Integer id;
	private Double latitude;
	private Double longitude;
	private LocalDateTime timestamp;
	private Integer userId;
	private String userName;
}
