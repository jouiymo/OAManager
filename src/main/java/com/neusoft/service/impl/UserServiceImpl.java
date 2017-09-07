package com.neusoft.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.neusoft.domain.Dept;
import com.neusoft.domain.User;
import com.neusoft.exception.MyException;
import com.neusoft.repository.UserRepository;
import com.neusoft.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User login(User user) throws MyException {
		ExampleMatcher matcher = ExampleMatcher.matching();
		// 构建对象
		// .withStringMatcher(StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
		// .withIgnoreCase(true); //改变默认大小写忽略方式：忽略大小写
		/*
		 * .withMatcher("address"(此处写相应对象的属性),
		 * GenericPropertyMatchers.startsWith()) //地址采用“开始匹配”的方式查询
		 * .withIgnorePaths("focus"); //忽略属性：是否关注。因为是基本类型，需要忽略掉
		 */ Example<User> ex = Example.of(user, matcher);
		 User user2 = null;
		try {
			 user2 = userRepository.findOne(ex);
		} catch (Exception e) {
			throw new MyException(81,"登录失败");
		}
		if(-1==user2.getState()){
			throw new MyException(81,"登录失败");
		}else return user2;
		
	}

	@Override
	public User logout(User user) {

		return null;
	}

	@Override
	public User add(User user) throws MyException {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new MyException(21, "添加新用户失败");
		}
		
	}

	@Override
	public User alter(User user) throws MyException {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new MyException(41, "修改用户失败");
		}
		
	}

	@Override
	public User del(User user) throws MyException {
		user.setState(-1);
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new MyException(53, "删除用户失败");
		}
		
		
	}

	@Override
	public List<User> findUserByEmpId(Integer empId) throws MyException {
		try {
			return userRepository.findByEidAndState(empId,1);
		} catch (Exception e) {
			throw new MyException(69, "查询用户列表失败");
		}
		
	}

	@Override
	public List<User> findUserByEmpName(String empName) throws MyException {
		try {
			return userRepository.findByEnameContainingAndState(empName,1);
		} catch (Exception e) {
			throw new MyException(69, "查询用户列表失败");
		}
	
	}

	@Override
	public List<User> findUserByRegDate(Date beginDay, Date finalDay) {
		return null;
	}

	@Override
	public Page<User> findUserByUser(User user, Pageable pageable) throws MyException {
		user.setState(1);
	/*	ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
				.withStringMatcher(StringMatcher.CONTAINING) // 改变默认字符串匹配方式：模糊查询
				.withIgnoreCase(true);
		// 改变默认大小写忽略方式：忽略大小写
		
		 * .withMatcher("address"(此处写相应对象的属性),
		 * GenericPropertyMatchers.startsWith()) //地址采用“开始匹配”的方式查询
		 * .withIgnorePaths("focus"); //忽略属性：是否关注。因为是基本类型，需要忽略掉
		  Example<User> ex = Example.of(user, matcher);*/
			try {
				return userRepository.findByAuto(user, pageable);
			} catch (Exception e) {
				throw new MyException(69, "查询用户列表失败");
			}
		
	}

}
