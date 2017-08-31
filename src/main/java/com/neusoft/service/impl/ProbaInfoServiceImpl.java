package com.neusoft.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.ProbationInformation;
import com.neusoft.exception.MyException;
import com.neusoft.repository.ProInfoRepository;
import com.neusoft.service.ProbaInfoService;

@Service
public class ProbaInfoServiceImpl implements ProbaInfoService {
	@Autowired
	private ProInfoRepository proInfoRepository;

	@Override
	@Transactional
	public ProbationInformation add(ProbationInformation probaInfo) throws MyException {
		try {
			return proInfoRepository.save(probaInfo);
		} catch (Exception e) {
			throw new MyException(14, "试用期信息录入失败");
		}
		
	}
	
	@Override
	@Transactional
	public ProbationInformation alterResult(Integer result, Integer empId) throws MyException {
		ProbationInformation probaInfo = proInfoRepository.findByEid(empId);
		probaInfo.setResult(result);
		try {
			return proInfoRepository.save(probaInfo);
		} catch (Exception e) {
			throw new MyException(34, "试用期信息修改失败");
		}
		
	}

}
