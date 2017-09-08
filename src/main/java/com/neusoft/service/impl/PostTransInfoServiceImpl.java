package com.neusoft.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.domain.EmployeeInfo;
import com.neusoft.domain.PostSwitch;
import com.neusoft.exception.MyException;
import com.neusoft.repository.EmpInfoRepository;
import com.neusoft.repository.PostRepository;
import com.neusoft.repository.PostTransInfoRepository;
import com.neusoft.service.PostTransInfoService;

@Service
public class PostTransInfoServiceImpl implements PostTransInfoService {
	@Autowired
	private PostTransInfoRepository postTransInfoRepository;
	@Autowired
	EmpInfoRepository empInfoRepository;
	@Autowired
	PostRepository postRepository;

	@Override
	@Transactional
	public PostSwitch add(PostSwitch postSwitch) throws MyException {
		try {
			EmployeeInfo employeeInfo = empInfoRepository.findOne(postSwitch.getEid());
			employeeInfo.setPostName(postRepository.findOne(postSwitch.getPostid()).getName());
			empInfoRepository.save(employeeInfo);
			return postTransInfoRepository.save(postSwitch);
		} catch (Exception e) {
			throw new MyException(15, "员工岗位调转信息录入失败");
		}
		
	}
	// 是否允许eid重复，即是否保存以往调转记录
	@Override
	@Transactional
	public PostSwitch alterPostType(Integer postType, Integer empId) throws MyException {
		PostSwitch postSwitch = postTransInfoRepository.findByEid(empId);
		postSwitch.setType(postType);
		try {
			return postTransInfoRepository.save(postSwitch);
		} catch (Exception e) {
			throw new MyException(35, "员工岗位调转信息修改失败");
		}
		
	}

}
