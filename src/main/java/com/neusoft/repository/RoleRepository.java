package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.Role;

public interface RoleRepository extends BaseJpaRepository<Role, Integer> {

	List<Role> findByState(int i);

}
