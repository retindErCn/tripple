package com.tripple.Repos;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;

@ComponentScan
public interface httpHeaderRepo extends JpaRepository<httpHeader, Long>,
		QueryDslPredicateExecutor<httpHeader> {
	List<httpHeader> findById(Long[] ids);
	Page<httpHeader> findByRequestid(Long requestId,Pageable page);
	List<httpHeader> findByRequestid(Long requestId);

}
