package com.neusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.PostSwitch;

public interface PostTransInfoRepository extends JpaRepository<PostSwitch, Integer> {

	PostSwitch findByEid(Integer empId);

}
