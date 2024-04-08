package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class RentVO {
	public Integer rentNo;
	public int bookNo;
	public int rentPrice;
	public Date rentDate;
	public String rentStatus;
	public String bookName;
}
