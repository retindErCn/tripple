package com.tripple.interfaces;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tripple.Entity.httpHeader;
import com.tripple.Entity.httpParams;
import com.tripple.Entity.httpRequest;
import com.tripple.api.pojo.trippleLog;
import com.tripple.api.pojo.trippleLog.logtype;
import com.tripple.api.service.apiService;
import com.tripple.api.service.headerService;
import com.tripple.api.service.paramsService;
import com.tripple.enumType.paramType;
import com.tripple.runtime.runTimeLog;
import com.tripple.runtime.testContext;
import com.tripple.suite.service.suiteToStepService;
import com.tripple.suite.service.testStepService;
import com.tripple.suite.service.testSuiteService;

/**
 * http 接口执行
 * 
 * @author Administrator
 *
 */

public class executor {

	OkHttpClient client = new OkHttpClient();

	testContext context = new testContext();
	runTimeLog logger;

	@Value("${upload.filepath}")
	String filePath;

	@Autowired
	headerService headerService;
	@Autowired
	paramsService paramsService;
	@Autowired
	apiService apiService;
	@Autowired
	suiteToStepService suiteToStepService;
	@Autowired
	testSuiteService testSuiteService;
	@Autowired
	testStepService testStepService;

	public void setLog(trippleLog log) {
		this.context.getRunTimeLogs().add(log);
	}

	public Queue<trippleLog> getLog() {
		return this.context.getRunTimeLogs();
	}

	public String doGet(httpRequest req, List<httpHeader> headers,
			List<httpParams> params) {
		Request.Builder buildReq = new Request.Builder();
		Response res = null;
		String result = "";
		if (!headers.isEmpty()) {
			headers.stream().forEach(
					x -> buildReq.addHeader(x.getHeaderName(),
							x.getHeaderValue()));
		}

		if (!params.isEmpty()) {
			params.stream().forEach(
					x -> req.setUrl(req.getUrl() + x.getParamName() + "="
							+ x.getParamValue()));
			req.setUrl(req.getUrl().substring(0, req.getUrl().length() - 1));
		}

		setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
				.message("BEGIN DO GET:").build());
		setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
				.message("GET:URL-->" + req.getUrl()).build());
		try {
			res = client.newCall(buildReq.url(req.getUrl()).build()).execute();
			result = res.body().string();
			setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
					.message("status code-->" + res.code()).build());
			setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
					.message("GET:Result-->" + result).build());
		} catch (Exception e) {
			// TODO: handle exception
			setLog(trippleLog.builder().logDate(new Date()).type(logtype.error)
					.message(e.getMessage()).build());
			this.context.setFailedTest(context.getFailedTest() + 1);

		} finally {
			if (isSucc(res.code())) {
				this.context.setPassedTest(context.getPassedTest() + 1);
			} else {
				this.context.setFailedTest(context.getFailedTest() + 1);
			}
			this.context.setTotal(context.getTotal() + 1);

		}
		return result;
	}

	/**
	 * 根据contentype，做不同的处理 目前仅支持3类contentype，后边有需要再加
	 * 
	 * @param req
	 * @param headers
	 * @param params
	 * @return
	 */

	public String doPOST(httpRequest req, List<httpHeader> headers,
			List<httpParams> params) {
		final String urlencoderhead = "application/x-www-form-urlencoded";
		final String multidata = "multipart/form-data";
		final String jsondata = "application/json";
		RequestBody requestBody;
		Request.Builder buildReq = new Request.Builder();
		Response res = null;
		String result = "";
		String contentType = "";
		if (!headers.isEmpty()) {
			headers.stream().forEach(
					x -> buildReq.addHeader(x.getHeaderName(),
							x.getHeaderValue()));
		}

		if (!params.isEmpty()) {
			params.stream().forEach(
					x -> req.setUrl(req.getUrl() + x.getParamName() + "="
							+ x.getParamValue()));
			req.setUrl(req.getUrl().substring(0, req.getUrl().length() - 1));
		}

		contentType = headers.stream()
				.filter(x -> x.getHeaderName().equals("Content-Type"))
				.findFirst().toString();
		if (contentType == "") {
			contentType = urlencoderhead;
		}
		contentType = contentType.trim();

		if (contentType.contains(urlencoderhead)) {
			FormBody.Builder body = new FormBody.Builder();
			params.stream().map(
					x -> body.add(x.getParamName(),
							valueConvert(x.getParamValue())));
			requestBody = body.build();
			setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
					.message("BEGIN DO POST:").build());
			setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
					.message("POST:URL-->" + req.getUrl()).build());
			try {
				res = client.newCall(
						buildReq.url(req.getUrl()).post(requestBody).build())
						.execute();
				result = res.body().toString();
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.debug)
						.message("status code-->" + res.code()).build());
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.debug).message("POST:Result-->" + result)
						.build());
			} catch (Exception e) {
				// TODO: handle exception
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.error).message(e.getMessage()).build());
				this.context.setFailedTest(context.getFailedTest() + 1);
			} finally {
				if (isSucc(res.code())) {
					this.context.setPassedTest(context.getPassedTest() + 1);
				} else {
					this.context.setFailedTest(context.getFailedTest() + 1);
				}
				this.context.setTotal(context.getTotal() + 1);

			}

			return result;
		}

		if (contentType.contains(multidata)) {

			MultipartBody.Builder multibuilder = new MultipartBody.Builder();

			params.stream()
					.filter(x -> x.getParamType().equals(paramType.File))
					.forEach(
							x -> {
								File file = new File(filePath, x
										.getParamValue());
								RequestBody fileBody = RequestBody.create(
										MediaType
												.parse("application/octet-stream"),
										file);
								multibuilder.addFormDataPart("file",
										x.getParamValue(), fileBody);
							});
			params.stream()
					.filter(x -> x.getParamType().equals(paramType.Text))
					.forEach(
							x -> {
								multibuilder.addFormDataPart(x.getParamName(),
										valueConvert(x.getParamValue()));
							});
			MultipartBody reBody = multibuilder.setType(MultipartBody.FORM)
					.build();
			setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
					.message("BEGIN DO POST:").build());
			setLog(trippleLog.builder().logDate(new Date()).type(logtype.debug)
					.message("POST:URL-->" + req.getUrl()).build());
			try {
				res = client.newCall(
						buildReq.url(req.getUrl()).post(reBody).build())
						.execute();
				result = res.body().toString();
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.debug)
						.message("status code-->" + res.code()).build());
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.debug).message("POST:Result-->" + result)
						.build());
			} catch (IOException e) {
				// TODO: handle exception
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.error).message(e.getMessage()).build());
				this.context.setFailedTest(context.getFailedTest() + 1);
			} finally {
				if (isSucc(res.code())) {
					this.context.setPassedTest(context.getPassedTest() + 1);
				} else {
					this.context.setFailedTest(context.getFailedTest() + 1);
				}
				this.context.setTotal(context.getTotal() + 1);
			}
			return result;
		}

		if (contentType.contains(jsondata)) {
			requestBody = RequestBody.create(MediaType.parse(contentType),
					jsonValueConvert(params.get(0).getParamValue()));
			try {
				res = client.newCall(
						buildReq.url(req.getUrl()).post(requestBody).build())
						.execute();
				result = res.body().toString();
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.debug)
						.message("status code-->" + res.code()).build());
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.debug).message("POST:Result-->" + result)
						.build());
			} catch (Exception e) {
				// TODO: handle exception
				setLog(trippleLog.builder().logDate(new Date())
						.type(logtype.error).message(e.getMessage()).build());
				this.context.setFailedTest(context.getFailedTest() + 1);
			} finally {
				if (isSucc(res.code())) {
					this.context.setPassedTest(context.getPassedTest() + 1);
				} else {
					this.context.setFailedTest(context.getFailedTest() + 1);
				}
				this.context.setTotal(context.getTotal() + 1);

			}

			return result;
		}
		return result;

	}

	String valueConvert(String paramValue) {
		if (paramValue.startsWith("$") && paramValue.contains(".")) {
			return context.getRuntimeVarivables().get(paramValue);
		} else {
			return paramValue;
		}
	}

	/**
	 * 如果是json
	 * 
	 * @param json
	 * @return
	 */

	String jsonValueConvert(String json) {
		Set<String> keyset = context.getRuntimeVarivables().keySet();
		Iterator<String> it = keyset.iterator();
		while (it.hasNext()) {
			String key = it.next();
			json = json.replace(key, context.getRuntimeVarivables().get(key));

		}

		return json;
	}

	/**
	 * 暂时只认200跟302是正常的
	 * 
	 * @param statusCode
	 * @return
	 */
	boolean isSucc(int statusCode) {
		return ((200 == statusCode) || 302 == (statusCode)) ? true : false;
	}

}
