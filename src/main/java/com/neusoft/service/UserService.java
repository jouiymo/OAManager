package com.neusoft.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neusoft.domain.User;
import com.neusoft.exception.MyException;

public interface UserService {

	// 用户登录
	public User login(User user) throws MyException;

	// 用户注销
	public User logout(User user) throws MyException;

	// 新增用户
	public User add(User user) throws MyException;

	// 修改用户
	public User alter(User user) throws MyException;

	// 删除用户
	public User del(User user) throws MyException;

	// 通过用户的员工编号查询用户列表
	public List<User> findUserByEmpId(Integer empId) throws MyException;

	// 通过用户的员工姓名查询用户列表
	public List<User> findUserByEmpName(String empName) throws MyException;

	// 通过用户注册时间查询用户列表
	public List<User> findUserByRegDate(Date beginDay, Date finalDay) throws MyException;

	// 通过构建不完整的用户查询用户列表
	public Page<User> findUserByUser(User user, Pageable pageable) throws MyException;

}
