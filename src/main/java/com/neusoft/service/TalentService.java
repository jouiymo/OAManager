package com.neusoft.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neusoft.domain.TalentInfo;
import com.neusoft.exception.MyException;

/**
 * 人才库service
 * 
 * @author sky
 *
 */
public interface TalentService {

	// 新增人才信息
	public TalentInfo add(TalentInfo talentInfo) throws MyException;

	// 修改人才信息
	public TalentInfo alter(TalentInfo talentInfo) throws MyException;

	// 删除人才信息
	public void del(TalentInfo talentInfo) throws MyException;

	// 通过姓名查询人才信息列表
	public List<TalentInfo> findTalentInfoByName(String name) throws MyException;

	// 通过性别查询人才信息列表
	public List<TalentInfo> findTalentInfoByGender(Integer gender) throws MyException;

	// 通过身份证号码查询人才信息列表
	public List<TalentInfo> findTalentInfoByIdNo(String IdNo) throws MyException;

	// 通过构建不完整的人才信息查询人才信息列表(查询条件为姓名，性别，身份证号码)
	public Page<TalentInfo> findTalentInfoByTalentInfo(TalentInfo talentInfo, Pageable pageable) throws MyException;
}
