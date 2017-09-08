package com.neusoft.repository;

import java.util.List;


import com.neusoft.domain.EmployeeInfo;

public interface EmpInfoRepository extends BaseJpaRepository<EmployeeInfo, Integer> {

	List<EmployeeInfo> findByNameContainingAndState(String userName,Integer state);

	List<EmployeeInfo> findByDeptName(String name);

	List<EmployeeInfo> findByPostName(String name);



	

}
