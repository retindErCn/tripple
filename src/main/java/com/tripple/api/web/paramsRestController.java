package com.tripple.api.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.apiRequest;
import com.tripple.api.pojo.headerDto;
import com.tripple.api.pojo.paramDto;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.api.service.paramsService;
import com.tripple.common.restResult;

@RestController
@RequestMapping(value = "/params")
public class paramsRestController {
	/**
	 * binder
	 */
	@Autowired
	paramsService service;

	@RequestMapping(value = "/{requestid}/add", method = RequestMethod.POST)
	public restResult<?> addParmas(paramDto param) {
		
		return restResult.Ok(service.addParam(param));
	}

	@RequestMapping(value = "/{requestid}/list", method = RequestMethod.GET)
	public Page<httpParams> ListApi(@PathVariable("requestid") Long params,
			Pageable page) {

		return service.getparamsByPage(params, page);
	}
}
