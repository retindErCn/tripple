package com.tripple.api.pojo;

import javax.jdo.annotations.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tripple.enumType.customOperator;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDto {

	String userName;
	String userPwd;
	String Email;

}
