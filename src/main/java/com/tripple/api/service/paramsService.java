package com.tripple.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;

import com.tripple.Repos.httpParamRepo;
import com.tripple.api.pojo.paramDto;
import com.tripple.api.pojo.paramDto;

@Component
public class paramsService {

	@Autowired
	httpParamRepo paramRepo;

	public void deleteParam(Long paramid) {
		paramRepo.delete(paramid);
	}

	public httpParams modifyParams(httpParams param, paramDto paramDto) {
		param.setParamName(paramDto.getParamName() == null ? param
				.getParamName() : paramDto.getParamName());
		param.setParamValue(paramDto.getParamValue() == null ? param
				.getParamValue() : paramDto.getParamValue());
		param.setDefaultValue(paramDto.getDefaultValue() == null ? param
				.getDefaultValue() : paramDto.getDefaultValue());
		param.setDescription(paramDto.getDescription() == null ? param
				.getDescription() : paramDto.getDescription());
		param.setIsMust(paramDto.getIsMust() == null ? param.getIsMust()
				: paramDto.getIsMust());
		final httpParams p = paramRepo.save(param);
		return p;

	}

	public httpParams infoParams(Long paramsid) {
		return paramRepo.findOne(paramsid);
	}

	public httpParams addParam(paramDto param) {
		httpParams x = httpParams.builder().requestid(param.getRequestid())
				.paramName(param.getParamName())
				.paramValue(param.getParamValue())
				.defaultValue(param.getDefaultValue())
				.description(param.getDescription()).isMust(param.getIsMust())
				.build();
		return paramRepo.save(x);
	}

	public Page<httpParams> getparamsByPage(Long requestid, Pageable page) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable x = new PageRequest(page.getPageNumber(), page.getPageSize(),
				sort);

		return paramRepo.findByRequestid(requestid, page);

	}
}
