package com.tripple.runtime;

import java.util.Date;

import org.springframework.stereotype.Component;

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
		context.getRuntimeVarivables().put(left, right);
	}

}
