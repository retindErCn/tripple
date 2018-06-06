package com.tripple.Repos;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;

@ComponentScan
public interface httpParamRepo extends JpaRepository<httpParams, Long>,
		QueryDslPredicateExecutor<httpParams> {
	List<httpParams> findById(Long[] ids);

	List<httpParams> findByRequestid(Long requestId);

	Page<httpParams> findByRequestid(Long requestId, Pageable page);

}
