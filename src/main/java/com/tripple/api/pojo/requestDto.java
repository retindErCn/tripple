package com.tripple.api.pojo;

import javax.jdo.annotations.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.tripple.enumType.apiLevel;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class requestDto {

	String name;
	String url;
	String httpMethod;
	Boolean isOn;

	String description;
	apiLevel apilevel;

}
