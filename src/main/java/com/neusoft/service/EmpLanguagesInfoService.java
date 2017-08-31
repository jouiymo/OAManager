package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.ForeignLanguages;
import com.neusoft.exception.MyException;

/**
 * 员工外语能力信息service
 * 
 * @author sky
 *
 */
public interface EmpLanguagesInfoService {

	// 员工外语能力信息录入
	public ForeignLanguages add(ForeignLanguages empLanguagesInfo) throws MyException;

	// 修改员工外语能力信息
	public ForeignLanguages alterEmpInfo(ForeignLanguages empLanguagesInfo) throws MyException;

	// 查询员工外语能力信息
	public List<ForeignLanguages> find(Integer empId) throws MyException;

}
