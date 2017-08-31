package com.neusoft.service;

import com.neusoft.domain.Quit;
import com.neusoft.exception.MyException;

/**
 * 离职信息service
 * 
 * @author sky
 *
 */
public interface EmpQuitInfoService {
	// 员工离职信息录入
	public Quit add(Quit quit) throws MyException;

	// 改变员工离职类型
	public Quit alterQuitType(Integer quitType, Integer empId) throws MyException;

}
