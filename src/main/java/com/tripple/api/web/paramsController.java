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

import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.header;
import com.tripple.api.pojo.headerDto;
import com.tripple.api.pojo.paramDto;
import com.tripple.api.pojo.requestDto;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.api.service.paramsService;
import com.tripple.common.restResult;

@RestController
@RequestMapping(value = "/params/{paramsId}")
public class paramsController {
	/**
	 * binder
	 */

	@Autowired
	paramsService params;

	@ModelAttribute
	public void fillRequest(@PathVariable("paramsId") httpParams params,
			ModelMap model) {
		model.put("params", params);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public restResult<?> deleteHeader(@PathVariable("paramsId") Long paramsId) {
		params.deleteParam(paramsId);
		return restResult.Ok();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public restResult<?> modifyApi(
			@Valid @ModelAttribute("params") httpParams e, paramDto  paramDto) {

		return restResult.Ok(params.modifyParams(e, paramDto));
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public restResult<?> infoOfApi(@PathVariable("paramsId") Long paramsId) {

		return restResult.Ok(params.infoParams(paramsId));
	}

}
