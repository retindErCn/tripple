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
import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.apiRequest;
import com.tripple.api.pojo.headerDto;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.common.restResult;

@RestController
@RequestMapping(value = "/header")
public class headerRestController {
	/**
	 * binder
	 */
	@Autowired
	headerService service;

	@RequestMapping(value = "/{requestid}/add", method = RequestMethod.POST)
	public restResult<?> addApi(headerDto header) {

		return restResult.Ok(service.addHeader(header));
	}

	@RequestMapping(value = "/{requestid}/list", method = RequestMethod.GET)
	public Page<httpHeader> ListApi(@PathVariable("requestid") Long requestid,
			Pageable page) {

		return service.getheaderByPage(requestid, page);
	}
}
