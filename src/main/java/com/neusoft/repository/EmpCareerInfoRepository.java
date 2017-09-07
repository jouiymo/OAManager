package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.Career;

public interface EmpCareerInfoRepository extends BaseJpaRepository<Career, Integer> {

	List<Career> findByEid(Integer empId);

}
