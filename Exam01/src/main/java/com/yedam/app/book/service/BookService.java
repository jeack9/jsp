package com.yedam.app.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> bookList();
	public int getLastNo();
	public boolean insertBook(BookVO bookVO);
	public List<RentVO> rentList();
}
