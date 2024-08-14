package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;
import com.yedam.app.book.service.RentVO;

public interface BookMapper {
	// 전체조회
	public List<BookVO> selectBookAll();
	// 마지막 도서번호 조회
	public int countBookNo();
	// 단건등록
	public int insertBook(BookVO bookVO);
	// 대여현황 조회
	public List<RentVO> selectRentAll();
}
