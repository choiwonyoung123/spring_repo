package com.yedam.app.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Controller // controller 어노테이션
public class BookController {
	
	@Autowired //
	BookService bookService; // 서비스를 접근하기 위한 서비스 정의
	
	// 도서 전체조회
	@GetMapping("bookList") // 주소 매핑
	public String bookList(Model model) { // model = req + resp
		List<BookVO> list = bookService.bookList(); // 서비스 인터페이스에 정의한 메소드 결과 가져오기
		model.addAttribute("books", list); // 요청 데이터 모델에 담기
		return "book/list"; // 문자열 형태로 뷰 페이지 요청, templates 폴더 > book 폴더 > list.html
	}
	// 도서 페이지 이동
	@GetMapping("bookInsert") // 주소 매핑
	public String bookInsertForm(Model model) { // 도서 번호 담을 모델 필요
		BookVO bookVO = bookService.getBookNo(); // 서비스 인터페인스에 정의한 메소드 결과 가져오기
		model.addAttribute("book", bookVO); // 도서 번호 담기
		return "book/insert"; // 뷰 페이지 요청
	}
	// 도서 등록 처리
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		bookService.bookInfoInsert(bookVO);  // 서비스 인터페인스에 정의한 메소드 결과 가져오기
		return "redirect:bookList"; // 등록이 끝난 후 전체조회 페이지로 되돌리기
	}
	// 도서 대여현황조회
	@GetMapping("rentInfo")
	public String rentInfo(Model model) { // model = req + resp
		List<BookVO> list = bookService.rentInfo(); // 서비스 인터페이스에 정의한 메소드 결과 가져오기
		model.addAttribute("rents", list); // 요청 데이터 모델에 담기
		return "book/rent"; // 문자열 형태로 뷰 페이지 요청, templates 폴더 > book 폴더 > rent.html
	}
}
