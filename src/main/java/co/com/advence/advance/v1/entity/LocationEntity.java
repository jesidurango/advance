package co.com.advence.advance.v1.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tr_locations")
public class LocationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double latitude;
	private Double longitude;
	private LocalDateTime timestamp;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	public LocationEntity() {}
	
	public LocationEntity(Integer id) {
		this.id = id;
	}
}
