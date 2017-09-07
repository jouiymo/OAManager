package com.neusoft.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neusoft.domain.MyLogger;
import com.neusoft.service.LoggerService;
@Service
public class LoggerServiceImpl implements LoggerService {
	@Autowired
	EntityManagerFactory eFactory;
	@Override
	public List<MyLogger> findByLog(MyLogger logger, Integer size, Integer page) {
		EntityManager em = eFactory.createEntityManager();
		return null;
	}
	@Override
	public List<MyLogger> findLogByStartDate(Date start, Integer size, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MyLogger> findLogByEndDate(Date end, Integer size, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MyLogger> findLogByEname(String Ename, Integer size, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MyLogger> findLogByEid(Integer empId, Integer size, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

}
