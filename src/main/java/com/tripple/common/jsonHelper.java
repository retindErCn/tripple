package com.tripple.common;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Component
public class jsonHelper {
	ObjectMapper mapper;
	
	public jsonHelper(){
		mapper=new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	
	public jsonHelper(JsonInclude.Include include){
		mapper=new ObjectMapper();
		mapper.setSerializationInclusion(include);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public String toJson(Object object) throws JsonProcessingException{
		return mapper.writeValueAsString(object);
	}
	 
	public <T> T fromJson(String json,Class<T> cls) throws JsonParseException, JsonMappingException, IOException{
		return mapper.readValue(json, cls);
	}
	
	public <T> T fromJson(String json, TypeReference reference)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(json, reference);
	}
}
