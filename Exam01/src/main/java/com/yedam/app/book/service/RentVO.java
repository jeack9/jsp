package com.yedam.app.book.service;

import lombok.Data;

@Data
public class RentVO {
	private int bookNo;
	private String bookName;
	private int rentSum;
	private int rentCount;
}
