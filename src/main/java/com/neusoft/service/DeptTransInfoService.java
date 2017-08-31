package com.neusoft.service;

import com.neusoft.domain.DeptSwitch;
import com.neusoft.exception.MyException;

/**
 * 员工部门调转信息service
 * 
 * @author sky
 *
 */
public interface DeptTransInfoService {
	// 员工部门调转信息录入
	public DeptSwitch add(DeptSwitch DeptSwitch) throws MyException;

	// 改变员工部门调转方式
	public DeptSwitch alterDeptTransMode(Integer DeptType, Integer empId) throws MyException;

}
