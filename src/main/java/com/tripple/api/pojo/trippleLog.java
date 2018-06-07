package com.tripple.api.pojo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@ToString
public class trippleLog {
	
	Date logDate;
	logtype type;
	String  message;
	public enum logtype{
		error,info,debug,verbose;
	}

}
