package com.tripple.suite.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/suite/{suiteId}")
public class testSuiteController {
	@Autowired
	testSuiteService service;

	@ModelAttribute
	public void fillRequest(@PathVariable("suiteId") testSuite testSuite,
			ModelMap model) {
		model.put("testSuite", testSuite);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public restResult<?> deleteSuite(@PathVariable("suiteId") Long suiteId) {
		service.deleteSuite(suiteId);
		return restResult.Ok();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public restResult<?> modifySuite(
			@Valid @ModelAttribute("testSuite") testSuite testSuite,
			suiteDto suiteDto) {

		return restResult.Ok(service.modifytestSuite(testSuite, suiteDto));
	}

}
