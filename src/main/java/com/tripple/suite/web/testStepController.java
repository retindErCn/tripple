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
import com.tripple.Entity.testStep;
import com.tripple.api.pojo.suiteToStepDto;
import com.tripple.api.pojo.testStepDto;
import com.tripple.common.restResult;
import com.tripple.suite.service.suiteToStepService;
import com.tripple.suite.service.testStepService;

@RestController
@RequestMapping(value = "/step/{stepid}")
public class testStepController {

	@Autowired
	testStepService service;

	@ModelAttribute
	public void fillRequest(@PathVariable("stepid") testStep testStep,
			ModelMap model) {
		model.put("testStep", testStep);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public restResult<?> deleteStep(@PathVariable("stepid") Long stepid) {
		service.deleteParam(stepid);
		return restResult.Ok();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public restResult<?> modifyStep(
			@Valid @ModelAttribute("suiteToStep") testStep testStep,
			testStepDto testStepDto) {

		return restResult.Ok(service.modifyStep(testStep, testStepDto));
	}

}
