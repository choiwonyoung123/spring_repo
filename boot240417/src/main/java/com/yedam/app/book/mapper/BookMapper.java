package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

public interface BookMapper {
	//도서 전체조회
	public List<BookVO> selectAllList();
	//도서 번호조회
	public BookVO getBookNo();
	//도서 등록
	public int insertBook(BookVO bookVO);
}
