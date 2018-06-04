package com.tripple.common;

import org.springframework.http.client.OkHttpClientHttpRequestFactory;

import lombok.Data;


@Data
public class  restResult<T> {
	
	T content;
	String status;
	
	String errorMessage;
	
	
	public restResult() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T> restResult<T> Ok(){
		restResult<T> result=new restResult<>();
		result.status="OK";
		return result;
	}
	
	public static <T> restResult<T> Ok(T  t){
		restResult<T> result=new restResult<>();
		result.status="OK";
		result.content=t;
		return result;
	}
	
	public static <T> restResult<T> error(String errorMessage){
		restResult<T> result=new restResult<>();
		result.status="OK";
		result.errorMessage=errorMessage;
		return result;
	}
}
