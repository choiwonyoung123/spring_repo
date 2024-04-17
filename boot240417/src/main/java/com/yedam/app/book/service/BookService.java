package com.yedam.app.book.service;

import java.util.List;

public interface BookService {
	// 도서 전체조회
	public List<BookVO> bookList();
	// 도서 번호조회
	public BookVO getBookNo();
	// 도서 등록
	public int bookInfoInsert(BookVO bookVO);
	// 도서 대여현황조회
	public List<BookVO> rentInfo();
}
