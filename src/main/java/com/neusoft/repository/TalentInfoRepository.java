package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.TalentInfo;

public interface TalentInfoRepository extends BaseJpaRepository<TalentInfo, Integer> {

	List<TalentInfo> findByNameContaining(String name);

	List<TalentInfo> findByGender(Integer gender);

	TalentInfo findByCardnumber(String idNo);

}
