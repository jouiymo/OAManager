package com.neusoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neusoft.domain.MyLogger;

/**
 * 日志service
 * 
 * @author sky
 *
 */
public interface LoggerService {

	// 通过构建不完整logger对象查询logger列表
	public Page<MyLogger> findByLog(MyLogger logger, Pageable pageable);

}
