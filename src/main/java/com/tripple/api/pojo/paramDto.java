package com.tripple.api.pojo;

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

	String defaultValue;

	String description;

	Boolean isMust;

}
