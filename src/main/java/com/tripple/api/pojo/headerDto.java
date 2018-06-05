package com.tripple.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class headerDto {
	
	 Long requestid;
	
	 String headerName;
	
	 String headerValue;
	
	 String description;

}
