package com.neusoft.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neusoft.domain.EmployeeInfo;
import com.neusoft.domain.Exam;
import com.neusoft.exception.MyException;

/**
 * 员工service
 * 
 * @author sky
 *
 */
public interface EmpService {

	// 新增员工信息
	public EmployeeInfo add(EmployeeInfo employee) throws MyException;

	// 修改员工信息
	public EmployeeInfo alter(EmployeeInfo employee) throws MyException;

	// 通过员工编号查询员工列表
	public Page<EmployeeInfo> findEmpByEmpId(Integer empid, Pageable pageable) throws MyException;

	// 通过员工姓名查询员工列表
	public List<EmployeeInfo> findEmpByEmpName(String userName) throws MyException;

	// 通过部门名称查询员工列表
	public Page<EmployeeInfo> findEmpByDeptName(String deptName, Pageable pageable) throws MyException;

	// 通过岗位名称查询员工列表
	public Page<EmployeeInfo> findEmpByPostName(String postName, Pageable pageable) throws MyException;

	// 通过员工部门调转方式查询员工列表
	public List<EmployeeInfo> findEmpByDeptType(Integer deptType) throws MyException;

	// 通过员工岗位调转方式查询员工列表
	public List<EmployeeInfo> findEmpByPostType(Integer postType) throws MyException;

	// 通过试用期状态查询员工列表
	public List<EmployeeInfo> findEmpByProbaStatus(Integer result) throws MyException;

	// 通过员工离职类型查询员工列表
	public List<EmployeeInfo> findEmpByQuitType(Integer quitType) throws MyException;

	// 通过岗位编号查询员工列表
	public List<EmployeeInfo> findEmpByPostId(Integer postId) throws MyException;

	// 通过部门编号查询员工列表
	public Page<EmployeeInfo> findEmpByDeptId(Integer deptId, Pageable pageable) throws MyException;

	// 通过部门调转的开始日期到结束日期查询员工列表
	public List<EmployeeInfo> findEmpByDeptTransDay(Date beginDay, Date finalDay) throws MyException;

	// 通过岗位调转的开始日期到结束日期查询员工列表
	public List<EmployeeInfo> findEmpByPostTransDay(Date beginDay, Date finalDay) throws MyException;

	// 通过离职的开始日期到结束日期查询员工列表
	public List<EmployeeInfo> findEmpByQuitDay(Date beginDay, Date finalDay) throws MyException;

	// 通过转正的开始日期到结束日期查询员工列表
	public List<EmployeeInfo> findEmpByTransDay(Date beginDay, Date finalDay) throws MyException;

	// 通过试用期开始日期查询员工列表
	public List<EmployeeInfo> findEmpByProbaBeginDay(Date beginDay) throws MyException;

	// 通过试用期结束日期查询员工列表
	public List<EmployeeInfo> findEmpByProbaFinalDay(Date finalDay) throws MyException;

	// 通过构建例子查询员工列表(已调动部门员工信息查询：查询条件为指定开始日期，结束日期，员工编号，员工姓名，调动方式。)
	public List<Exam> findExamByDeptTransExam(Exam exam, Integer size, Integer page) throws MyException;

	// 通过构建例子查询员工列表(已调动岗位员工信息查询：查询条件为开始日期，结束日期，员工编号，员工姓名，调动方式。)
	public List<Exam> findExamByPostTransExam(Exam exam, Integer size, Integer page) throws MyException;

	// 通过构建例子查询员工列表(已离职员工信息查询：查询条件为开始日期，结束日期，员工编号，员工姓名，部门名称，岗位名称，离职类型。)
	public List<Exam> findExamByQuitExam(Exam exam, Integer size, Integer page) throws MyException;

	// 通过构建例子查询员工列表(已转正员工信息查询：查询条件：开始日期，结束日期，部门编号，部门名称，员工编号，员工姓名)
	public List<Exam> findExamByTransExam(Exam exam, Integer size, Integer page) throws MyException;

	// 通过构建例子查询员工列表(试用期员工信息查询：.查询条件包括：员工编号，员工姓名，部门名称，岗位名称，试用期状态，试用期开始日期，试用期结束日期。)
	public List<Exam> findExamByProbaExam(Exam exam, Integer size, Integer page) throws MyException;

	// 通过构建例子查询员工列表(<员工信息中心，员工离职管理，岗位调动管理，部门调动管理>通用员工列表查询：查询条件为部门编号，部门名称，员工编号，员工姓名。)
	public List<Exam> findExamBySimpleExam(Exam exam, Integer size, Integer page) throws MyException;
}
