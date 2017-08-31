package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.DeptSwitch;

public interface DeptTransInfoRepository extends JpaRepository<DeptSwitch, Integer> {

	List<DeptSwitch> findByEid(Integer empId);

}
