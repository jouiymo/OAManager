package com.neusoft;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class LogbackTset {

	Logger logger = LoggerFactory.getLogger(LogbackTset.class);

	@RequestMapping("/log")
	@ResponseBody
	String test(HttpServletRequest req) {
		logger.info("logback 成功了");
		logger.error("logback 成功了");
		return "Hello World!";
	}
}
