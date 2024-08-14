package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookVO;

@SpringBootTest
class Exam01ApplicationTests {
	
	@Autowired
	BookMapper bookMapper;
	//@Test
	void bookList() {
		List<BookVO> list = bookMapper.selectBookAll();
		assertTrue(!list.isEmpty());
	}
}
