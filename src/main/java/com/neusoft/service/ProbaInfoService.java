package com.neusoft.service;

import com.neusoft.domain.ProbationInformation;
import com.neusoft.exception.MyException;

/**
 * 试用期信息service
 * 
 * @author sky
 *
 */
public interface ProbaInfoService {
	// 试用期信息录入
	public ProbationInformation add(ProbationInformation probaInfo) throws MyException;

	// 改变试用期状态
	public ProbationInformation alterResult(Integer result, Integer empId) throws MyException;

}
