package com.yedam.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookVO {
	// book 테이블
	public int bookNo;
	public String bookName;
	public String bookCoverimg;
	@DateTimeFormat(pattern="yyyy-MM-dd") // 날짜타입 포맷 정의 어노테이션
	public Date bookDate;
	public int bookPrice;
	public String bookPublisher;
	public String bookInfo;
	// rent 테이블
	private int rentCount;
	private int rentTotalPrice;
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCoverimg() {
		return bookCoverimg;
	}
	public void setBookCoverimg(String bookCoverimg) {
		this.bookCoverimg = bookCoverimg;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
	public int getRentCount() {
		return rentCount;
	}
	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}
	public int getRentTotalPrice() {
		return rentTotalPrice;
	}
	public void setRentTotalPrice(int rentTotalPrice) {
		this.rentTotalPrice = rentTotalPrice;
	}
	
	
}
