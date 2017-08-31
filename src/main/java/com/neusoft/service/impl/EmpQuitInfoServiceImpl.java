package com.neusoft.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.Quit;
import com.neusoft.exception.MyException;
import com.neusoft.repository.EmpQuitInfoRepository;
import com.neusoft.service.EmpQuitInfoService;

@Service
public class EmpQuitInfoServiceImpl implements EmpQuitInfoService {
	@Autowired
	private EmpQuitInfoRepository empQuitInfoRepository;

	@Override
	@Transactional
	public Quit add(Quit quit) throws MyException {
		try {
			return empQuitInfoRepository.save(quit);
		} catch (Exception e) {
			throw new MyException(17, "员工离职信息录入失败");
		}
		
	}

	@Override
	@Transactional
	public Quit alterQuitType(Integer quitType, Integer empId) throws MyException {
		Quit quit = empQuitInfoRepository.findByEid(empId);
		quit.setType(quitType);
		try {
			return empQuitInfoRepository.save(quit);
		} catch (Exception e) {
			throw new MyException(37, "员工离职信息修改失败");
		}
		
	}

}
