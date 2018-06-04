package com.tripple.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;
import com.tripple.Repos.httpHeaderRepo;
import com.tripple.Repos.httpParamRepo;
import com.tripple.Repos.httpRequestRepo;
import com.tripple.api.pojo.apiRequest;
import com.tripple.api.pojo.header;
import com.tripple.common.jsonHelper;

@Component
public class apiService {

	@Autowired
	httpRequestRepo httpRequestRepo;
	@Autowired
	httpHeaderRepo httpHeaderRepo;
	@Autowired
	httpParamRepo httpParamRepo;
	@Autowired
	jsonHelper jsonHelper;

	public apiRequest generateAPI(Map<?, ?> map) {
		String method = (String) map.get("method");
		Map<String, String> params = new HashMap<>();
		List<String> temp = new ArrayList<>();
		List<header> header = new ArrayList<>();
		String json = null;
		try {
			json = jsonHelper.toJson(map.get("requestHeaders"));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray headerArray = JSONArray.parseArray(json);
		Iterator<Object> it = headerArray.iterator();
		while (it.hasNext()) {
			JSONObject h = (JSONObject) it.next();
			header.add(new header(String.valueOf(h.get("name")), String
					.valueOf(h.get("value"))));
		}

		if (method.equals("GET")) {
			return apiRequest.builder().url(map.get("url").toString())
					.method(method).requestHeaders(header)
					.reqId(Integer.parseInt(map.get("requestId").toString()))
					.build();
		}

		if ("POST".equals(method)) {
			try {
				json = jsonHelper.toJson(map.get("requestBody"));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject paramsJson = (JSONObject) JSONPath.eval(
					JSONObject.parse(json), "$.formData");
			Set<String> keys = paramsJson.keySet();
			Iterator<String> param = keys.iterator();
			while (param.hasNext()) {
				String paramName = param.next();
				String paramValue = String.valueOf(paramsJson.get(paramName));
				//paramValue = paramValue.substring(2, paramValue.length() - 2);
				params.put(paramName, paramValue);

			}

			return apiRequest.builder().url(map.get("url").toString())
					.method(method).requestHeaders(header).requestBody(params)
					.reqId(Integer.parseInt(map.get("requestId").toString()))
					.build();
		}

		return null;
	}

	@Transactional
	public httpRequest apiSaved(apiRequest api) {
		
		System.out.println(api.toString());
		httpRequest request = httpRequest.builder().url(api.getUrl())
				.httpMethod(api.getMethod()).build();
		final httpRequest req = httpRequestRepo.save(request);
		api.getRequestHeaders()
				.stream()
				.forEach(
						x -> {
							httpHeader header = httpHeader.builder()
									.requestid(req.getId())
									.headerName(x.getName())
									.headerValue(x.getValue()).build();
							httpHeaderRepo.save(header);
						});

		api.getRequestBody()
				.keySet()
				.forEach(
						x -> {
							httpParams param = httpParams.builder()
									.paramName(x)
									.paramValue(api.getRequestBody().get(x))
									.requestid(req.getId()).build();
							httpParamRepo.save(param);
						});
		return req;
	}

}
