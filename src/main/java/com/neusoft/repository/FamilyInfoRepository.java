package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.FamilyInfo;

public interface FamilyInfoRepository extends JpaRepository<FamilyInfo, Integer> {

	List<FamilyInfo> findByEid(Integer empId);

}
