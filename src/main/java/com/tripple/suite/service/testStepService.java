package com.tripple.suite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.tripple.Entity.testStep;
import com.tripple.Repos.testStepRepo;
import com.tripple.api.pojo.paramDto;
import com.tripple.api.pojo.testStepDto;
import com.tripple.enumType.customOperator;

public class testStepService {

	@Autowired
	testStepRepo testStepRepo;

	public void deleteParam(Long stepid) {
		testStepRepo.delete(stepid);
	}

	public testStep modifyStep(testStep teststep, testStepDto testStepDto) {
		teststep.setStepName(testStepDto.getStepName() == null ? teststep
				.getStepName() : testStepDto.getStepName());

		teststep.setLeftVar(testStepDto.getLeftVar() == null ? teststep
				.getLeftVar() : testStepDto.getLeftVar());

		teststep.setRightVar(testStepDto.getRightVar() == null ? teststep
				.getRightVar() : testStepDto.getRightVar());

		teststep.setOperator(testStepDto.getOperator() == null ? teststep
				.getOperator() : testStepDto.getOperator());

		teststep.setRequestid(testStepDto.getRequestid() == null ? teststep
				.getRequestid() : testStepDto.getRequestid());

		teststep.setDescription(testStepDto.getDescription() == null ? teststep
				.getDescription() : testStepDto.getDescription());

		final testStep p = testStepRepo.save(teststep);
		return p;

	}

	public testStep infoTestStep(Long stepid) {
		return testStepRepo.findOne(stepid);
	}

	public testStep addTestStep(testStepDto testStepDto) {
		testStep x = testStep.builder().requestid(testStepDto.getRequestid())
				.description(testStepDto.getDescription())
				.stepName(testStepDto.getStepName())
				.leftVar(testStepDto.getLeftVar())
				.rightVar(testStepDto.getRightVar())
				.operator(testStepDto.getOperator()).build();
		return testStepRepo.save(x);
	}

	public Page<testStep> gettestStepByPage(Pageable page) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable x = new PageRequest(page.getPageNumber(), page.getPageSize(),
				sort);

		return testStepRepo.findAll(page);

	}
	
	public List<testStep> gettestStepByTestsuiteId(Long testsuiteid) {
	

		return testStepRepo.findByTestSuiteId(testsuiteid);

	}

}
