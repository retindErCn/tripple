package com.tripple.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpRequest;
import com.tripple.Repos.httpHeaderRepo;
import com.tripple.api.pojo.headerDto;

@Component
public class headerService {

	@Autowired
	httpHeaderRepo headerRepo;

	public void deleteHeader(Long headerid) {
		headerRepo.delete(headerid);
	}

	public httpHeader modifyHeader(httpHeader header, headerDto headerdto) {
		header.setHeaderName(headerdto.getHeaderName() == null ? header
				.getHeaderName() : headerdto.getHeaderName());
		header.setHeaderValue(headerdto.getHeaderValue() == null ? header
				.getHeaderValue() : headerdto.getHeaderValue());
		header.setDescription(headerdto.getDescription() == null ? header
				.getDescription() : headerdto.getDescription());
		final httpHeader h = headerRepo.save(header);
		return h;

	}

	public httpHeader infoHeader(Long headerid) {
		return headerRepo.findOne(headerid);
	}

	public httpHeader addHeader(headerDto header) {
		httpHeader x = httpHeader.builder().requestid(header.getRequestid())
				.headerName(header.getHeaderName())
				.headerValue(header.getHeaderValue()).build();
		return headerRepo.save(x);
	}

	public Page<httpHeader> getheaderByPage(Long requestid, Pageable page) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable x = new PageRequest(page.getPageNumber(), page.getPageSize(),
				sort);

		return headerRepo.findByRequestid(requestid, page);

	}

	public List<httpHeader> getHeaderByRequestid(Long requestid) {

		return headerRepo.findByRequestid(requestid);

	}
}
