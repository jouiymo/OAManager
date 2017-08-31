package com.neusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.Quit;

public interface EmpQuitInfoRepository extends JpaRepository<Quit, Integer> {

	Quit findByEid(Integer empId);

}
