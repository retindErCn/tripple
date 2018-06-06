package com.tripple.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.Entity.suiteToStep;
import com.tripple.Entity.testSuite;
import com.tripple.api.pojo.suiteDto;
import com.tripple.api.pojo.suiteToStepDto;
import com.tripple.common.restResult;
import com.tripple.suite.service.suiteToStepService;
import com.tripple.suite.service.testSuiteService;

@RestController
@RequestMapping(value = "/suite")
public class testSuiteRestController {
	@Autowired
	testSuiteService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public restResult<?> addSuite(suiteDto suiteDto) {

		return restResult.Ok(service.addParam(suiteDto));
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Page<testSuite> ListSuite(Pageable page) {

		return service.gettestSuiteByPage(page);
	}

}
