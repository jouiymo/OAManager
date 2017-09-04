package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.Role;
import com.neusoft.exception.MyException;
import com.neusoft.repository.RoleRepository;
import com.neusoft.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;
	@Override
	public Role add(Role role) throws MyException {
		try {
			return roleRepository.save(role);
		} catch (Exception e) {
			throw new MyException(22, "添加新角色失败");
		}
		
	}

	@Override
	public Role alter(Role role) throws MyException {
		try {
			return roleRepository.save(role);
		} catch (Exception e) {
			throw new MyException(42, "修改角色失败");
		}
	
	}

	@Override
	public Role del(Role role) throws MyException {
		role.setState(-1);
		try {
			return roleRepository.save(role);
		} catch (Exception e) {
			throw new MyException(54, "删除角色失败");
		}
	}

	@Override
	public List<Role> findAll() throws MyException {
		
		try {
			return roleRepository.findByState(1);
		} catch (Exception e) {
			throw new MyException(70, "查询角色表失败");
		}
		
	}

	@Override
	public Role findByRoleId(Integer roleId) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

}
