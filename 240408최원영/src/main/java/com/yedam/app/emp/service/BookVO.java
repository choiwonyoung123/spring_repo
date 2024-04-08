package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class BookVO {
	public Integer bookNo;
	public String bookName;
	public String bookCoverimg;
	public Date bookDate;
	public int bookPrice;
	public String bookPublisher;
	public String bookInfo;
}
