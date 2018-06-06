package com.tripple.suite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tripple.Entity.httpParams;
import com.tripple.Entity.testSuite;
import com.tripple.Repos.suiteToStepRepo;
import com.tripple.Repos.testSuiteRepo;
import com.tripple.api.pojo.paramDto;
import com.tripple.api.pojo.suiteDto;

@Component
public class testSuiteService {

	@Autowired
	testSuiteRepo suiteRepo;

	@Autowired
	suiteToStepService suiteToStepService;

	@Transactional
	public void deleteSuite(Long testsuiteId) {
		suiteRepo.delete(testsuiteId);

	}

	public testSuite modifytestSuite(testSuite testsuite, suiteDto suiteDto) {
		testsuite.setSuiteName(suiteDto.getSuiteName() == null ? testsuite
				.getSuiteName() : suiteDto.getSuiteName());

		testsuite.setDescription(suiteDto.getDescription() == null ? testsuite
				.getDescription() : suiteDto.getDescription());

		final testSuite p = suiteRepo.save(testsuite);
		return p;

	}

	public testSuite infoSuite(Long suiteid) {
		return suiteRepo.findOne(suiteid);
	}

	public testSuite addParam(suiteDto suiteDto) {
		testSuite x = testSuite.builder()
				.description(suiteDto.getDescription())
				.suiteName(suiteDto.getSuiteName()).build();
		return suiteRepo.save(x);
	}

	public Page<testSuite> gettestSuiteByPage(Pageable page) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable x = new PageRequest(page.getPageNumber(), page.getPageSize(),
				sort);

		return suiteRepo.findAll(page);

	}

}
