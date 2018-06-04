package com.tripple.Repos;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.testStep;

@ComponentScan
public interface testStepRepo extends JpaRepository<testStep, Long>,
		QueryDslPredicateExecutor<testStep> {
	List<testStep> findById(Long[] ids);

}
