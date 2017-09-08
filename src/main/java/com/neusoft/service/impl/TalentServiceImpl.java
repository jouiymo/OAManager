package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.neusoft.domain.Dept;
import com.neusoft.domain.TalentInfo;
import com.neusoft.exception.MyException;
import com.neusoft.repository.TalentInfoRepository;
import com.neusoft.service.TalentService;
@Service
public class TalentServiceImpl implements TalentService {
	@Autowired
	TalentInfoRepository talentInfoRepository;
	@Override
	public TalentInfo add(TalentInfo talentInfo) throws MyException {
		
		return talentInfoRepository.save(talentInfo);
	}

	@Override
	public TalentInfo alter(TalentInfo talentInfo) throws MyException {
		
		return talentInfoRepository.save(talentInfo);
	}

	@Override
	public List<TalentInfo> findTalentInfoByName(String name) throws MyException {
		return talentInfoRepository.findByNameContaining(name);
	}

	@Override
	public List<TalentInfo> findTalentInfoByGender(Integer gender) throws MyException {
		return talentInfoRepository.findByGender(gender);
	}

	@Override
	public TalentInfo findTalentInfoByIdNo(String IdNo) throws MyException {
		
		return talentInfoRepository.findByCardnumber(IdNo);
	}

	@Override
	public Page<TalentInfo> findTalentInfoByTalentInfo(TalentInfo talentInfo, Pageable pageable) throws MyException {
		/*ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
				.withStringMatcher(StringMatcher.CONTAINING) // 改变默认字符串匹配方式：模糊查询
				.withIgnoreCase(true);
		// 改变默认大小写忽略方式：忽略大小写
		
		 * .withMatcher("address"(此处写相应对象的属性),
		 * GenericPropertyMatchers.startsWith()) //地址采用“开始匹配”的方式查询
		 * .withIgnorePaths("focus"); //忽略属性：是否关注。因为是基本类型，需要忽略掉
		  Example<TalentInfo> ex = Example.of(talentInfo, matcher);*/
		Page<TalentInfo> page = talentInfoRepository.findByAuto(talentInfo, pageable);
	
		if (null == page.getContent()) {
			throw new MyException(82, "查询人才库列表失败！");
		}
		return page;
	}

	@Override
	public void del(TalentInfo talentInfo) throws MyException {
		try {
			talentInfoRepository.delete(talentInfo);
		} catch (Exception e) {
			throw new MyException(55, "删除人才信息失败");
		}
		
	}

}
