package com.tripple.api.pojo;

import javax.jdo.annotations.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tripple.enumType.stepType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class suiteToStepDto {

	Integer stepOrder;

	String description;
	
	stepType type;
	
	Long testsuiteId;
	
	Long stepId;

}
