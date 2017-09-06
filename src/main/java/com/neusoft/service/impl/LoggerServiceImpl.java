package com.neusoft.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neusoft.domain.MyLogger;
import com.neusoft.service.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService {

	@Override
	public Page<MyLogger> findByLog(MyLogger logger, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
