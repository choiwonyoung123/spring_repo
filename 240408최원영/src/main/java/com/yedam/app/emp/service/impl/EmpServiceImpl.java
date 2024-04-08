package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.BookVO;
import com.yedam.app.emp.service.EmpReqVO;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.emp.service.RentVO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper mapper;

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return mapper.getEmp(vo);
	}

	@Override
	public List<EmpVO> getEmpList(EmpReqVO vo) {
		return mapper.getEmpList(vo);
	}

	@Override
	public List<EmpVO> getEmpByDept(String[] dept) {
		return mapper.getEmpByDept(dept);
	}

	@Override
	public int insert(EmpVO vo) {
		return mapper.insert(vo);
	}

	//도서정보 등록
	@Override
	public int addBook(BookVO bookVO) {
		int result = mapper.insertBook(bookVO);
		if(result == 1) {
			return bookVO.getBookNo();
		}
		else {
			return -1;
		}
	}

	@Override
	public BookVO getBookNo() {
		return mapper.getBookNo();
	}

	@Override
	public List<BookVO> bookList() {
		return mapper.selectBookList();
	}

	@Override
	public List<RentVO> rentList() {
		return mapper.selectRentList();
	}

}
