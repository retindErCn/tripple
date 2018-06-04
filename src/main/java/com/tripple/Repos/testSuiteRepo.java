package com.tripple.Repos;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.testSuite;

@ComponentScan
public interface testSuiteRepo extends JpaRepository<testSuite, Long>,
		QueryDslPredicateExecutor<testSuite> {
	List<testSuite> findById(Long[] ids);

}
