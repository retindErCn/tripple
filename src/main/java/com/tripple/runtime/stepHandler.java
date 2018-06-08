package com.tripple.runtime;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.alibaba.druid.sql.visitor.functions.Substring;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.tripple.api.pojo.trippleLog;
import com.tripple.api.pojo.trippleLog.logtype;
import com.tripple.enumType.customOperator;

@Component
public class stepHandler {

	public boolean doJudge(String left, String right, customOperator operator) {
		boolean result = false;
		switch (operator) {
		case EquallTo:
			result = left == null ? right == null : left.equals(right);
			break;
		case GreaterThan:
			result = Integer.parseInt(left) > Integer.parseInt(right);
			break;
		case LowerThan:
			result = Integer.parseInt(left) < Integer.parseInt(right);
			break;
		case Contains:
			result = left.contains(right);
			break;
		case NotContains:
			result = !left.contains(right);
			break;

		default:
			break;
		}

		return result;
	}

	public void doVar(testContext context, String left, String right) {
		if (context.getRuntimeVarivables().containsKey(left)) {
			context.getRunTimeLogs().add(
					trippleLog
							.builder()
							.type(logtype.info)
							.logDate(new Date())
							.message(
									"runningVars contains:" + left
											+ ". It will be overwrite!!")
							.build());
		}
		// 如果是之前接口返回的json的path作为参数，稍微做一下转换
		// 如：$.134.Response.content;
		// 134 代表requestid，代表执行134的返回之后，取返回的content
		if (right.startsWith("$") && right.contains(".")) {
			int index = right.indexOf("Response");
			String key = right.substring(0, index).replace("$", "")
					.replace(".", "");
			String json = context.getRuntimeVarivables().get(key);
			if (json != null) {
				right = JSONPath.eval(JSONObject.parse(json),
						"$" + right.substring(index + 8)).toString();
			}
		}
		context.getRuntimeVarivables().put(left, right);
	}

}
