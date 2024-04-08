package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.BookVO;
import com.yedam.app.emp.service.EmpReqVO;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.emp.service.RentVO;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	int insert(EmpVO vo);
	
	//도서정보 등록
	public int insertBook(BookVO bookVO);
	public BookVO getBookNo();
	public List<BookVO> selectBookList();
	public List<RentVO> selectRentList();
}
