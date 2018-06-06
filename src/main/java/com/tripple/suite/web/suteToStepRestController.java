package com.tripple.suite.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.Entity.httpRequest;
import com.tripple.Entity.suiteToStep;
import com.tripple.api.pojo.apiRequest;
import com.tripple.api.pojo.requestDto;
import com.tripple.api.pojo.suiteToStepDto;
import com.tripple.api.service.apiService;
import com.tripple.common.restResult;
import com.tripple.suite.service.suiteToStepService;

@RestController
@RequestMapping(value = "/suiteToStep")
public class suteToStepRestController {
	@Autowired
	suiteToStepService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public restResult<?> addSuiteToStep(suiteToStepDto suiteToStepDto) {

		return restResult.Ok(service.addsuiteToStep(suiteToStepDto));
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Page<suiteToStep> ListApi(Long testsuiteid, Pageable page) {

		return service.getsuiteToStepByPage(testsuiteid, page);
	}

}
