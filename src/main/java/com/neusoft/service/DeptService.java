package com.neusoft.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neusoft.domain.Dept;
import com.neusoft.exception.MyException;

/**
 * 部门service
 * 
 * @author sky
 *
 */
public interface DeptService {
	// 新增部门
	public Dept add(Dept dept) throws MyException ;

	// 修改部门
	public Dept alter(Dept dept) throws MyException;

	// 删除部门
	public Dept del(Dept dept) throws MyException;

	// 通过部门编号查询部门列表
	public List<Dept> findDeptByDeptId(Integer id) throws MyException ;

	// 通过部门名称查询部门列表
	public List<Dept> findDeptByDeptName(String name) throws MyException;

	// 通过部门类型查询部门列表
	public List<Dept> findDeptByDeptType(Integer type) throws MyException;

	// 通过构建不完整的部门查询部门列表
	public Page<Dept> findDeptByDept(Dept dept,Pageable pageable) throws MyException;

}
