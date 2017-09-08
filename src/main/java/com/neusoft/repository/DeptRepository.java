package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.neusoft.domain.Dept;

public interface DeptRepository extends BaseJpaRepository<Dept, Integer>{

	public List<Dept> findByNameContainingAndState(String name,Integer states);

	public List<Dept> findByTypeAndState(Integer type,Integer state);

	public Dept findByIdAndState(Integer id,Integer state);

	
}
