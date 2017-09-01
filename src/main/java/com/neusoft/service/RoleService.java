package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.Role;
import com.neusoft.exception.MyException;

/**
 * 角色service
 * 
 * @author sky
 *
 */
public interface RoleService {
	// 新增角色
	public Role add(Role user) throws MyException;

	// 修改角色
	public Role alter(Role user) throws MyException;

	// 删除角色
	public Role del(Role user) throws MyException;

	// 查询角色列表
	public List<Role> findAll() throws MyException;

	// 通过角色Id查询角色
	public Role findByRoleId(Integer roleId) throws MyException;
}
