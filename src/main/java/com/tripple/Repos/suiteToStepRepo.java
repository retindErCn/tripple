package com.tripple.Repos;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.suiteToStep;

@ComponentScan
public interface suiteToStepRepo extends JpaRepository<suiteToStep, Long>,
		QueryDslPredicateExecutor<suiteToStep> {
	List<suiteToStep> findById(Long[] ids);

	Page<suiteToStep> findByTestsuiteId(Long testsuiteid, Pageable page);

	List<suiteToStep> findByTestsuiteId(Long testsuiteid);

}
