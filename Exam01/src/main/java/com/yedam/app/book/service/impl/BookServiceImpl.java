package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
	private BookMapper bookMapper;

	@Override
	public List<BookVO> bookList() {
		return bookMapper.selectBookAll();
	}

	@Override
	public int getLastNo() {
		return bookMapper.countBookNo();
	}

	@Override
	public boolean insertBook(BookVO bookVO) {
		int result = bookMapper.insertBook(bookVO);
		return result == 1;
	}

	@Override
	public List<RentVO> rentList() {
		return bookMapper.selectRentAll();
	}

}
