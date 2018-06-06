package com.tripple.api.pojo;

import javax.jdo.annotations.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class suiteDto {
	String suiteName;

	
	String description;
}
