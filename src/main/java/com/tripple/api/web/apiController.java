package com.tripple.api.web;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.Entity.httpRequest;
import com.tripple.common.restResult;




@RestController
@RequestMapping(value="/api/{requestId}")
public class apiController {
	/**
	 * binder
	 */
	@ModelAttribute
	public void fillRequest(@PathVariable("requestId") httpRequest request,ModelMap model){
		model.put("httpRequest", request);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public restResult<?> deleteApi(@PathVariable("requestId") Long requestId){
		
		return restResult.Ok();
	}
}
