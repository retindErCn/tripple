package com.tripple.api.web;

import java.awt.print.Pageable;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.requestDto;
import com.tripple.api.service.apiService;
import com.tripple.common.restResult;

@RestController
@RequestMapping(value = "/api/{requestId}")
public class apiController {
	/**
	 * binder
	 */

	@Autowired
	apiService api;

	@ModelAttribute
	public void fillRequest(@PathVariable("requestId") httpRequest request,
			ModelMap model) {
		model.put("httpRequest", request);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public restResult<?> deleteApi(@PathVariable("requestid") Long reqid) {
		api.deleteAPI(reqid);
		return restResult.Ok();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public restResult<?> modifyApi(
			@Valid @ModelAttribute("httpRequest") httpRequest request,
			requestDto requestdto) {
		
		return restResult.Ok(api.modifyAPI(request,requestdto));
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public restResult<?> infoOfApi(@PathVariable("requestId") Long requestId) {
		
		return restResult.Ok(api.infoAPI(requestId));
	}

	
}
