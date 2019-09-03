package com.example.thinking.common.util;

import org.slf4j.Logger;

public class LoggerUtil {

	public static void info(String sessionId, Logger log, String msg) {
		log.info("sessionId:{}, msg{1}",sessionId, msg);
	}
	
}
