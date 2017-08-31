package com.neusoft.service;

import com.neusoft.domain.PostSwitch;
import com.neusoft.exception.MyException;

/**
 * 岗位调转信息service
 * 
 * @author sky
 *
 */
public interface PostTransInfoService {
	// 员工岗位调转信息录入
	public PostSwitch add(PostSwitch postSwitch) throws MyException;

	// 改变员工岗位调转方式
	public PostSwitch alterPostType(Integer postType, Integer empId) throws MyException;

}
