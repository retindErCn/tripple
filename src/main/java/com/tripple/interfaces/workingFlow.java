package com.tripple.interfaces;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;
import com.tripple.Entity.suiteToStep;
import com.tripple.Entity.testStep;
import com.tripple.api.pojo.trippleLog;
import com.tripple.api.pojo.trippleLog.logtype;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.api.service.paramsService;
import com.tripple.enumType.stepType;
import com.tripple.runtime.stepHandler;
import com.tripple.runtime.testContext;
import com.tripple.suite.service.suiteToStepService;
import com.tripple.suite.service.testStepService;

@Component
public class workingFlow {

	@Value("${upload.filepath}")
	String filePath;

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

	public void runTestSuite(Long testSuiteId, testContext context) {
		executor exeInstance = new executor(new OkHttpClient(), context,
				filePath);
		List<suiteToStep> steps = suiteToStepService
				.getsuiteToStep(testSuiteId);
		steps = steps.stream()
				.sorted(Comparator.comparing(suiteToStep::getStepOrder))
				.collect(Collectors.toList());

		for (suiteToStep s : steps) {
			testStep step = testStepService.infoTestStep(s.getStepId());
			switch (s.getType()) {

			case judge:
				/**
				 * 如果断言失败，就不用继续了
				 *
				 */

				if (!stepHandler.doJudge(step.getLeftVar(), step.getRightVar(),
						step.getOperator())) {
					context.setFailedTest(context.getFailedTest() + 1);
					context.setTotal(context.getTotal() + 1);
					return;
				} else {
					context.setFailedTest(context.getPassedTest() + 1);
					context.setTotal(context.getTotal() + 1);
				}
				break;
			case request:
				runSingleInterFace(step.getRequestid(), context);
				break;
			case var:
				stepHandler.doVar(context, step.getLeftVar(), step.getRightVar());
				break;

			default:
				break;
			}
		}

	}

	public List<trippleLog> runSingleInterFace(Long requestId,
			testContext context) {
		executor exeInstance = new executor(new OkHttpClient(), context,
				filePath);
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
