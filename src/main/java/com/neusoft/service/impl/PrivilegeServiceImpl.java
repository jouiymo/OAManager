package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.Privilege;
import com.neusoft.repository.PrivilegeRepository;
import com.neusoft.service.PrivilegeService;
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	@Autowired
	PrivilegeRepository privilegeRepository;
	@Override
	public List<Privilege> findAll() {
		
		return privilegeRepository.findAll();
	}

	@Override
	public Privilege findByPId(Integer privilegeId) {
		
		return privilegeRepository.findOne(privilegeId);
	}

}
