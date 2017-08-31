package com.neusoft.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.FamilyInfo;
import com.neusoft.exception.MyException;
import com.neusoft.repository.FamilyInfoRepository;
import com.neusoft.service.EmpFamilyInfoService;
@Service
public class EmpFamilyInfoServiceImpl implements EmpFamilyInfoService {
	@Autowired
	private FamilyInfoRepository familyInfoRepository;
	@Override
	@Transactional
	public FamilyInfo add(FamilyInfo empFamilyInfo) throws MyException {
		try {
			return familyInfoRepository.save(empFamilyInfo);
		} catch (Exception e) {
			throw new MyException(19, "员工家庭成员及社会关系信息录入失败");
		}
		
	}

	@Override
	@Transactional
	public FamilyInfo alterEmpInfo(FamilyInfo empFamilyInfo) throws MyException {
		try {
			return familyInfoRepository.save(empFamilyInfo);
		} catch (Exception e) {
			throw new MyException(39, "员工家庭成员及社会关系信息修改失败");
		}
		
	}

	@Override
	public List<FamilyInfo> find(Integer empId) throws MyException {
		try {
			return familyInfoRepository.findByEid(empId);
		} catch (Exception e) {
			throw new MyException(71, "查询员工家庭成员及社会关系信息失败");
		}
		
	}

}
