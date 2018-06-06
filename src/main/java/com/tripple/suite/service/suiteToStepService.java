package com.tripple.suite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.tripple.Entity.suiteToStep;
import com.tripple.Repos.suiteToStepRepo;
import com.tripple.api.pojo.suiteToStepDto;

public class suiteToStepService {
	@Autowired
	suiteToStepRepo suiteToStepRepo;

	public void deleteStep(Long suiteToStepId) {
		suiteToStepRepo.delete(suiteToStepId);
	}

	/**
	 * 关联表没什么可以改的，最多改改顺序跟描述。不然就是直接解除了
	 * 
	 * @param suiteToStep
	 * @param suiteToStepDto
	 * @return
	 */
	public suiteToStep modifyStep(suiteToStep suiteToStep,
			suiteToStepDto suiteToStepDto) {
		suiteToStep
				.setDescription(suiteToStepDto.getDescription() == null ? suiteToStep
						.getDescription() : suiteToStepDto.getDescription());

		suiteToStep
				.setStepOrder(suiteToStepDto.getStepOrder() == null ? suiteToStep
						.getStepOrder() : suiteToStepDto.getStepOrder());

		final suiteToStep p = suiteToStepRepo.save(suiteToStep);
		return p;

	}

	public suiteToStep addsuiteToStep(suiteToStepDto suiteToStepDto) {
		suiteToStep x = suiteToStep.builder()
				.description(suiteToStepDto.getDescription())
				.testsuiteId(suiteToStepDto.getTestsuiteId())
				.stepId(suiteToStepDto.getStepId())
				.stepOrder(suiteToStepDto.getStepOrder()).build();
		return suiteToStepRepo.save(x);
	}

	public Page<suiteToStep> getsuiteToStepByPage(Long testsuiteid,
			Pageable page) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable x = new PageRequest(page.getPageNumber(), page.getPageSize(),
				sort);

		return suiteToStepRepo.findByTestSuiteId(testsuiteid, page);

	}

	public List<suiteToStep> getsuiteToStep(Long testsuiteid) {

		return suiteToStepRepo.findByTestSuiteId(testsuiteid);

	}

}
