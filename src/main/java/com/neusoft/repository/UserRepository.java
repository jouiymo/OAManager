package com.neusoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {


	List<User> findByEnameContainingAndState(String empName, int state);

	List<User> findByEidAndState(Integer empId, int state);

}
