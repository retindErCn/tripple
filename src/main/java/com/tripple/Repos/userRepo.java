package com.tripple.Repos;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.testSuite;
import com.tripple.Entity.user;

@ComponentScan
public interface userRepo extends JpaRepository<user, Long>,
		QueryDslPredicateExecutor<testSuite> {
	List<user> findById(Long[] ids);
	user findByUserName(String username);

}
