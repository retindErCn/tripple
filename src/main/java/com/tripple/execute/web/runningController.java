package com.tripple.execute.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tripple.Entity.suiteToStep;
import com.tripple.api.pojo.trippleLog;
import com.tripple.common.restResult;
import com.tripple.interfaces.trippleLogger;
import com.tripple.interfaces.workingFlow;
import com.tripple.runtime.testContext;
import com.tripple.suite.service.suiteToStepService;

@RestController
@RequestMapping(value = "/runsuite/{suiteId}")
public class runningController {
	@Autowired
	workingFlow runningEngine;

	@RequestMapping(value = "/run", method = RequestMethod.POST)
	public String runsuit(@PathVariable("suiteId") Long suiteId) {
		testContext context = new testContext();
		runningEngine.runTestSuite(suiteId, context);
		trippleLogger.map.put(context.getUniqid(), context);
		return context.getUniqid();
	}

	@RequestMapping(value = "/getLog", method = RequestMethod.GET)
	public List<trippleLog> runsuit(String uniqid) {
		testContext context = trippleLogger.map.get(uniqid);
		return context.getRunTimeLogs();

	}
}
