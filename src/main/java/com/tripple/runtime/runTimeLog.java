package com.tripple.runtime;

import java.util.Date;

import com.tripple.api.pojo.trippleLog;
import com.tripple.api.pojo.trippleLog.logtype;

/**
 * 运行时的日志
 * 
 * @author Administrator
 *
 */
public class runTimeLog {

	public trippleLog infoLog(String Message) {
		return trippleLog.builder().type(logtype.info).logDate(new Date())
				.message(Message).build();
	}

	public trippleLog errorLog(String Message) {
		return trippleLog.builder().type(logtype.error).logDate(new Date())
				.message(Message).build();
	}

	public trippleLog debugLog(String Message) {
		return trippleLog.builder().type(logtype.debug).logDate(new Date())
				.message(Message).build();
	}

	public trippleLog verboseLog(String Message) {
		return trippleLog.builder().type(logtype.verbose).logDate(new Date())
				.message(Message).build();
	}

}
