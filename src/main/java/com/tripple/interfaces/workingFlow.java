package com.tripple.interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;
import com.tripple.Entity.suiteToStep;
import com.tripple.api.pojo.trippleLog;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.api.service.paramsService;
import com.tripple.runtime.stepHandler;
import com.tripple.suite.service.suiteToStepService;
import com.tripple.suite.service.testStepService;

@Component
public class workingFlow {

	@Autowired
	apiService apiService;

	@Autowired
	headerService headerService;

	@Autowired
	paramsService paramsService;

	@Autowired
	suiteToStepService suiteToStepService;

	@Autowired
	testStepService testStepService;

	@Autowired
	stepHandler stepHandler;

	public void runTestSuite(Long testSuiteId) {
		executor exeInstance = new executor();
		List<suiteToStep> steps = suiteToStepService
				.getsuiteToStep(testSuiteId);
		steps = steps.stream()
				.sorted(Comparator.comparing(suiteToStep::getStepOrder))
				.collect(Collectors.toList());

		steps.stream().forEach(x -> {
			switch (x.getType()) {
			case judge:

				break;
			case request:

				break;
			case var:

				break;

			default:
				break;
			}
		});

	}

	public Queue<trippleLog> runSingleInterFace(Long requestId) {
		executor exeInstance = new executor();
		httpRequest req = apiService.infoAPI(requestId);
		List<httpHeader> headers = headerService
				.getHeaderByRequestid(requestId);
		List<httpParams> params = paramsService.getparamsByRequestid(requestId);
		switch (req.getHttpMethod()) {
		case "GET":
			exeInstance.doGet(req, headers, params);
			break;

		case "POST":
			exeInstance.doPOST(req, headers, params);
			break;

		default:
			break;
		}

		return exeInstance.context.getRunTimeLogs();
	}

	public String getRunTimeLog() {
		return null;
	}

}
