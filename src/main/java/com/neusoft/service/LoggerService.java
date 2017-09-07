package com.neusoft.service;

import java.util.Date;
import java.util.List;

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

	// 通过开始时间查询日志列表
	public List<MyLogger> findLogByStartDate(Date start, Integer size, Integer page);

	// 通过结束时间查询日志列表
	public List<MyLogger> findLogByEndDate(Date end, Integer size, Integer page);

	// 通过员工姓名查询日志列表
	public List<MyLogger> findLogByEname(String Ename, Integer size, Integer page);

	// 通过员工编号查询日志列表
	public List<MyLogger> findLogByEid(Integer empId, Integer size, Integer page);

	// 通过构建不完整logger对象查询logger列表
	public List<MyLogger> findByLog(MyLogger logger, Integer size, Integer page);

}
