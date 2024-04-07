package com.yedam.app.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.dept.service.DeptVO;

@Mapper
public interface DeptMapper {
	//전체조회
	public List<DeptVO> selectDeptAll();
	//단건조회
	public DeptVO selectDept(DeptVO deptVO);
	//등록 - 사원등록
	public int insertDept(DeptVO deptVO);
}
