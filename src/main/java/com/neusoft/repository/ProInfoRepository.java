package com.neusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.ProbationInformation;

public interface ProInfoRepository extends BaseJpaRepository<ProbationInformation, Integer> {

	ProbationInformation findByEid(Integer empId);

}
