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

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.header;
import com.tripple.api.pojo.headerDto;
import com.tripple.api.pojo.requestDto;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.common.restResult;

@RestController
@RequestMapping(value = "/header/{headerId}")
public class headerController {
	/**
	 * binder
	 */

	@Autowired
	headerService header;

	@ModelAttribute
	public void fillRequest(@PathVariable("headerId") httpHeader header,
			ModelMap model) {
		model.put("header", header);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public restResult<?> deleteHeader(@PathVariable("headerId") Long headerId) {
		header.deleteHeader(headerId);
		return restResult.Ok();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public restResult<?> modifyApi(
			@Valid @ModelAttribute("header") httpHeader e, headerDto headerDto) {

		return restResult.Ok(header.modifyHeader(e, headerDto));
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public restResult<?> infoOfApi(@PathVariable("headerId") Long headerId) {

		return restResult.Ok(header.infoHeader(headerId));
	}

}
