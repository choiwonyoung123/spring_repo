package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional // 구문 내 한 트랜잭션으로 묶음
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("a101");
	}
}
