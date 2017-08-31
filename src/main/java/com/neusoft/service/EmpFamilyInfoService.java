package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.FamilyInfo;
import com.neusoft.exception.MyException;

/**
 * 员工家庭成员及社会关系信息service
 * 
 * @author sky
 *
 */
public interface EmpFamilyInfoService {

	// 员工家庭成员及社会关系信息录入
	public FamilyInfo add(FamilyInfo empFamilyInfo) throws MyException;

	// 修改员工家庭成员及社会关系信息
	public FamilyInfo alterEmpInfo(FamilyInfo empFamilyInfo) throws MyException;

	// 查询员工家庭成员及社会关系信息
	public List<FamilyInfo> find(Integer empId) throws MyException;
}
