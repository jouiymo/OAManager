package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.ForeignLanguages;

public interface ForeignLanguagesRepository extends BaseJpaRepository<ForeignLanguages, Integer> {

	List<ForeignLanguages> findByEid(Integer empId);

}
