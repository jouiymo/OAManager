package com.neusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.PostSwitch;

public interface PostTransInfoRepository extends BaseJpaRepository<PostSwitch, Integer> {

	PostSwitch findByEid(Integer empId);

}
