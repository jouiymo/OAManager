package com.neusoft.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.EmployeeInfo;

public interface EmpInfoRepository extends JpaRepository<EmployeeInfo, Integer> {

	List<EmployeeInfo> findByNameContainingAndState(String userName,Integer state);

	Page<EmployeeInfo> findByDeptNameContainingAndState(String deptName,Integer state, Pageable pageable);

	Page<EmployeeInfo> findByPostNameContainingAndState(String postName,Integer state, Pageable pageable);


	

}
