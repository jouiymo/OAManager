package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

	public List<Dept> findByNameContainingAndState(String name,Integer states);

	public List<Dept> findByTypeAndState(Integer type,Integer state);

	public List<Dept> findByIdAndState(Integer id,Integer state);

	
}