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
import com.tripple.api.pojo.suiteToStepDto;
import com.tripple.common.restResult;
import com.tripple.suite.service.suiteToStepService;


@RestController
@RequestMapping(value = "/suiteToStep/{suiteId}")
public class suiteToStepController {
	@Autowired
	suiteToStepService suiteToStepService;

	@ModelAttribute
	public void fillRequest(@PathVariable("suiteId") suiteToStep suiteToStep,
			ModelMap model) {
		model.put("suiteToStep", suiteToStep);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public restResult<?> deleteStep(@PathVariable("suiteId") Long suiteId) {
		suiteToStepService.deleteStep(suiteId);
		return restResult.Ok();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public restResult<?> modifyStep(
			@Valid @ModelAttribute("suiteToStep") suiteToStep suiteToStep,
			suiteToStepDto suiteToStepDto) {

		return restResult.Ok(suiteToStepService.modifyStep(suiteToStep,
				suiteToStepDto));
	}

}
