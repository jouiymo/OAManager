package com.neusoft.service;

import com.neusoft.domain.Privilege;

/**
 * 权限service
 * 
 * @author sky
 *
 */
public interface PrivilegeService {
	//查询权限表
	public Privilege findAll();
	//通过权限Id查询权限
	public Privilege findByPId(Integer privilegeId);
	
	
}
