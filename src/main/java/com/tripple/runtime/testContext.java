package com.tripple.runtime;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.tripple.Entity.BusinessEntity;
import com.tripple.api.pojo.trippleLog;

/**
 * 测试执行的上下文
 * 
 * @author Administrator
 *
 */

@Data
@AllArgsConstructor
@ToString
@Builder
public class testContext {

	HashMap<String, String> runtimeVarivables;
	List<trippleLog> runTimeLogs;
	int passedTest;
	int failedTest;
	int skipedTest;
	int total;
	String uniqid;

	public testContext() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");

		this.uniqid = uuidStr;
	}

}
