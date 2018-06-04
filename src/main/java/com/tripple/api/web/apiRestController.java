package com.tripple.api.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.apiRequest;
import com.tripple.api.service.apiService;
import com.tripple.common.restResult;




@RestController
@RequestMapping(value="/api/")
public class apiRestController {
	/**
	 * binder
	 */
	@Autowired apiService service;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public restResult<?> addApi(@RequestBody Map api){
		apiRequest req=service.generateAPI(api);
		return restResult.Ok(service.apiSaved(req));
	}
}
