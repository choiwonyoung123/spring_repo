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
	//등록(오라클 >> 정수값 반환)
	public int insertEmp(EmpVO empVO);
	//수정(오라클 >> 정수값 반환)
	public int updateEmp(EmpVO empVO);
	//삭제(오라클 >> 정수값 반환)
	public int deleteEmp(int employeeId);
}
