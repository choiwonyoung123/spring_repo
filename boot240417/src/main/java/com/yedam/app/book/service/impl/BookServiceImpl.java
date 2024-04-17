package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.mapper.RentMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Service // 서비스 어노테이션
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookMapper bookMapper; // book 매퍼 정의
	@Autowired
	RentMapper rentMapper; // rent 매퍼 정의
	// 도서 전체조회
	@Override
	public List<BookVO> bookList() { // 컨트롤에서 호출되는 메소드
		return bookMapper.selectAllList(); // 매퍼 인터페이스에 정의한 메소드의 결과 반환
	}
	// 도서 번호조회
	@Override
	public BookVO getBookNo() {
		return bookMapper.getBookNo();
	}
	// 도서 등록
	@Override
	public int bookInfoInsert(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}
	// 도서 대여현황조회
	@Override
	public List<BookVO> rentInfo() {
		return rentMapper.selectRentInfo();
	}

}
