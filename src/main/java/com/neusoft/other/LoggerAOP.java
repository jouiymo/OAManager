package com.neusoft.other;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.neusoft.domain.MyLogger;
import com.neusoft.domain.ResJson;
import com.neusoft.util.ResJsonUtil;

/**
 * 切面日志
 * 
 * @author sky
 *
 */
@Aspect
@Component
@Order(2)
public class LoggerAOP {

	private final static Logger logger = LoggerFactory.getLogger(LoggerAOP.class);

	@Pointcut("execution(* com.neusoft.controller.*.**(..))")
	public void logPc() {
	}

	// 记录http请求相关信息
	@Around("logPc()")
	public void httpLog(ProceedingJoinPoint pjp) throws Throwable {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();

		// 用户没有登录，前台接收此错误请直接跳转到登录界面
		if (session == null) {
			return;
		}
		// 获取请求IP
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		// 员工id
		Integer empId = (Integer) session.getAttribute("empId");
		// 员工姓名
		String empname = (String) session.getAttribute("empName");
		// 用户名
		String username = (String) session.getAttribute("userName");
		// 请求地址
		StringBuffer url = request.getRequestURL();
		// 请求方法
		String medthod = request.getMethod();
		// 请求类方法
		String class_medthod = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
		// 访问开始时间
		Long starTime = System.currentTimeMillis();
		// 运行被切方法
		pjp.proceed();
		// 访问结束时间
		Long endTime = System.currentTimeMillis();
		// 耗时
		Long time = endTime - starTime;

		logger.info("username={},empId={},empname={},starTime={},endTime={},time={},url={},medthod={},class_medthod={}",
				username, empId, empname, starTime, endTime, time, url, medthod, class_medthod);

	}

}
