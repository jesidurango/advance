package co.com.advence.advance.v1.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ActivityProject {

	@NotNull
	private Integer projectId;
	@NotNull
	private List<Integer> activities;
	
}
