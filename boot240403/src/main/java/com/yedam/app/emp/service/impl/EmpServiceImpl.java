package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpMapper empMapper; //mapper bean 사용

	@Override
	public List<EmpVO> empList() {
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO empInfo(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public int empInsert(EmpVO empVO) {
		int result = empMapper.insertEmp(empVO);
		if(result == 1) {
			return empVO.getEmployeeId();
		}
		else {			
			return -1;
		}
	}

	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>(); // let map = {};
		boolean isSuccessed = false;
		int result = empMapper.updateEmp(empVO);
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", empVO); // 값 넣기 >> map.target = {employeeId: '', lastName = '' ... }
		return map;
	}

	@Override
	public Map<String, Object> empDelete(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		int result = empMapper.deleteEmp(empVO.getEmployeeId());
		if(result == 1) {			
			map.put("employeeId", empVO.getEmployeeId());
		}
		return map;
	}

	@Override
	public EmpVO getEmpId() {
		return empMapper.getEmpId();
	}
}
