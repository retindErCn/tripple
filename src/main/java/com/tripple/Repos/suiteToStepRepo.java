package com.tripple.Repos;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.suiteToStep;

@ComponentScan
public interface suiteToStepRepo extends JpaRepository<suiteToStep, Long>,
		QueryDslPredicateExecutor<suiteToStep> {
	List<suiteToStep> findById(Long[] ids);

}
