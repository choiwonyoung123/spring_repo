package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.emp.service.EmpVO;

@Mapper //mapper 어노테이션
public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectEmpAll();
	//단건조회
	public EmpVO selectEmp(EmpVO empVO);
	//마이바티스 >> @Param >> 객체 이름 지정, 매개변수 2개 이상인 경우 >> 모든 필드에 이름 붙이기 emp.employeeId
	//public EmpVO selectEmp(@Param("emp")EmpVO empVO);
	//등록(오라클 >> 정수값 반환)
	public int insertEmp(EmpVO empVO);
	//수정(오라클 >> 정수값 반환)
	public int updateEmp(EmpVO empVO);
	//삭제(오라클 >> 정수값 반환)
	public int deleteEmp(int employeeId);
	//마이바티스 >> @Param >> 매개변수 이름 지정 >> 여러개면 각각 지정
	//public int deleteEmp(@Param("eid")int employeeId);
	
	// 등록할 사원번호 조회
	public EmpVO getEmpId();
}
