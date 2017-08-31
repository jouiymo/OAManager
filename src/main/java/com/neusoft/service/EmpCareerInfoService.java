package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.Career;
import com.neusoft.exception.MyException;

/**
 * 员工职业生涯信息service
 * 
 * @author sky
 *
 */
public interface EmpCareerInfoService {

	// 员工职业生涯信息录入
	public Career add(Career empCareerInfo) throws MyException;

	// 修改员工职业生涯信息
	public Career alterEmpInfo(Career empCareerInfo) throws MyException;

	// 查询员工职业生涯信息
	public List<Career> find(Integer empId) throws MyException;
}
