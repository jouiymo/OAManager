package com.neusoft.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.Career;
import com.neusoft.exception.MyException;
import com.neusoft.repository.EmpCareerInfoRepository;
import com.neusoft.service.EmpCareerInfoService;

@Service
public class EmpCareerInfoServiceImpl implements EmpCareerInfoService {
	@Autowired
	private EmpCareerInfoRepository empCareerInfoRepository;

	@Override
	@Transactional
	public Career add(Career empCareerInfo) throws MyException {

		try {
			return empCareerInfoRepository.save(empCareerInfo);
		} catch (Exception e) {
			throw new MyException(18, "员工职业生涯信息录入失败");
		}
	}

	@Override
	@Transactional
	public Career alterEmpInfo(Career empCareerInfo) throws MyException {
		try {
			return empCareerInfoRepository.save(empCareerInfo);
		} catch (Exception e) {
			throw new MyException(38, "员工职业生涯信息修改失败");
		}
		
	}

	@Override
	public List<Career> find(Integer empId) throws MyException {
		try {
			return empCareerInfoRepository.findByEid(empId);
		} catch (Exception e) {
			throw new MyException(72, "查询职业生涯信息失败");
		}
		
	}

}
