package com.neusoft.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.DeptSwitch;
import com.neusoft.exception.MyException;
import com.neusoft.repository.DeptTransInfoRepository;
import com.neusoft.service.DeptTransInfoService;

@Service
public class DeptTransInfoServiceImpl implements DeptTransInfoService {
	@Autowired
	private DeptTransInfoRepository deptTransInfoRepository;

	@Override
	@Transactional
	public DeptSwitch add(DeptSwitch DeptSwitch) throws MyException {
		try {
			return  deptTransInfoRepository.save(DeptSwitch);
		} catch (Exception e) {
			throw new MyException(16, "员工部门调转信息录入失败");
		}
		
	}

	// 只有部门调转方式的改变，调转部门没有改变的？
	@Override
	@Transactional
	public DeptSwitch alterDeptTransMode(Integer type, Integer empId) throws MyException {
		DeptSwitch deptSwitch = deptTransInfoRepository.findByEid(empId).get(0);
		deptSwitch.setType(type);
		try {
			return deptTransInfoRepository.save(deptSwitch);
		} catch (Exception e) {
			throw new MyException(36, "员工部门调转信息修改失败");
		}
		
	}

}
