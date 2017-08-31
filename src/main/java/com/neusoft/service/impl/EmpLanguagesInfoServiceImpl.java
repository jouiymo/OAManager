package com.neusoft.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.ForeignLanguages;
import com.neusoft.exception.MyException;
import com.neusoft.repository.ForeignLanguagesRepository;
import com.neusoft.service.EmpLanguagesInfoService;

@Service
public class EmpLanguagesInfoServiceImpl implements EmpLanguagesInfoService {
	@Autowired
	private ForeignLanguagesRepository foreignLanguagesRepository;

	@Override
	@Transactional
	public ForeignLanguages add(ForeignLanguages empLanguagesInfo) throws MyException {
		try {
			return foreignLanguagesRepository.save(empLanguagesInfo);
		} catch (Exception e) {
			throw new MyException(20, "员工外语能力信息录入失败");
		}
		
	}

	@Override
	@Transactional
	public ForeignLanguages alterEmpInfo(ForeignLanguages empLanguagesInfo) throws MyException {
		try {
			return foreignLanguagesRepository.save(empLanguagesInfo);
		} catch (Exception e) {
			throw new MyException(40, "员工外语能力信息修改失败");
		}
		
	}

	@Override
	public List<ForeignLanguages> find(Integer empId) throws MyException {
		try {
			return foreignLanguagesRepository.findByEid(empId);
		} catch (Exception e) {
			throw new MyException(70, "查询员工外语能力信息失败");
		}
		
	}

}
