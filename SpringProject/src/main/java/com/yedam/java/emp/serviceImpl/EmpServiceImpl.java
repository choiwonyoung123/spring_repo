package com.yedam.java.emp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Service //serviceImpl 클래스 >> bean 어노테이션 추가
public class EmpServiceImpl implements EmpService{
	
	@Autowired //필드주입 방식
	EmpMapper empMapper;
	/*
	@Autowired //생성자주입 방식 >> 안정적인 방식
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}*/
	@Override
	public List<EmpVO> empAllList() {
		return empMapper.selectEmpAll(); //mapper.xml 메소드 연결
	}
	
}
