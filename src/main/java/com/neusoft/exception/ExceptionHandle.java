package com.neusoft.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.domain.ResJson;
import com.neusoft.util.ResJsonUtil;

/**
 * 异常的捕获及处理
 * 
 * @author sky
 *
 */
@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

//	/**
//	 * 未定义异常
//	 * 
//	 * @param ex
//	 * @return
//	 */
//	@ExceptionHandler(value = Exception.class)
//	@ResponseBody
//	public ResJson handle(Exception ex) {
//		
//		logger.error("系统异常", ex);
//		ResJson json = ResJsonUtil.error(-1, "未知错误");
//		return json;
//
//	}
//	 未定义异常由springboot自带的异常管理类去处理
	/**
	 * 自定义异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public ResJson handleMyException(MyException ex) {
		
		ResJson json = ResJsonUtil.error(ex.getCode(), ex.getMsg());
		return json;
	}

}
