package com.tripple.interfaces;

import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.trippleLog;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.api.service.paramsService;

@Component
public class workingFlow {

	@Autowired
	apiService apiService;

	@Autowired
	headerService headerService;

	@Autowired
	paramsService paramsService;

	public void runTestSuite(Long testSuiteId) {
		executor exeInstance = new executor();
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
