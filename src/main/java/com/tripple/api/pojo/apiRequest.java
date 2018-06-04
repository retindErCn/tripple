package com.tripple.api.pojo;



import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class apiRequest {
	
	int reqId;
	String method;
	String requestBodyType;
	List<header> requestHeaders;
	String url;
	Map<String, String> requestBody;
	

}
