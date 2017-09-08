package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.User;

public interface UserRepository extends BaseJpaRepository<User, Integer> {


	List<User> findByEnameContainingAndState(String empName, int state);

	User findByEidAndState(Integer empId, int state);

}
