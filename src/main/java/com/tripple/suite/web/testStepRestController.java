package com.tripple.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.Entity.suiteToStep;
import com.tripple.Entity.testStep;
import com.tripple.api.pojo.suiteToStepDto;
import com.tripple.api.pojo.testStepDto;
import com.tripple.common.restResult;
import com.tripple.suite.service.suiteToStepService;
import com.tripple.suite.service.testStepService;

@RestController
@RequestMapping(value = "/step")
public class testStepRestController {

	@Autowired
	testStepService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public restResult<?> addSuiteToStep(testStepDto testStepDto) {

		return restResult.Ok(service.addTestStep(testStepDto));
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Page<testStep> ListApi(Pageable page) {

		return service.gettestStepByPage(page);
	}

}
