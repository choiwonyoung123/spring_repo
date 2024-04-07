package com.yedam.app.dept.service;

import java.util.List;

public interface DeptService {
	//전체조회 - 부서리스트
	public List<DeptVO> deptList();
	//단건조회 - 부서정보
	public DeptVO deptInfo(DeptVO deptVO);
	//등록 - 사원등록
	public int deptInsert(DeptVO deptVO);
}
