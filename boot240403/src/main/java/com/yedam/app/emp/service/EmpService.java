package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

//비즈니스 클래스
public interface EmpService {
	//전체조회 - 사원리스트
	public List<EmpVO> empList();
	//단건조회 - 사원정보
	public EmpVO empInfo(EmpVO empVO);
	//등록 - 사원등록
	public int empInsert(EmpVO empVO);
	//수정 - 사원수정
	public Map<String, Object> empUpdate(EmpVO empVO);
	//삭제 - 사원삭제
	public Map<String, Object> empDelete(EmpVO empVO);
	//등록할 사원 번호 조회
	public EmpVO getEmpId();
}
