package com.tripple.api.pojo;

import com.tripple.enumType.paramType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paramDto {

	Long requestid;

	String paramName;

	String paramValue;
	paramType paramType;
	String defaultValue;

	String description;

	Boolean isMust;

}
