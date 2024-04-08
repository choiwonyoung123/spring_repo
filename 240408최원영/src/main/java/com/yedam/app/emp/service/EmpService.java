package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	int insert(EmpVO vo);
	
	//도서정보 등록
	public int addBook(BookVO bookVO);
	public BookVO getBookNo();
	public List<BookVO> bookList();
	public List<RentVO> rentList();
}

