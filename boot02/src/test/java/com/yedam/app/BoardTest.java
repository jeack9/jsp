package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@SpringBootTest
public class BoardTest {
	@Autowired
	BoardMapper mapper;
	
	//@Test
	void boardList() {
		assertTrue(!mapper.selectBoardAll().isEmpty());
	}
	
	@Test
	void boardInfo() {
		BoardVO findVO = mapper.selectBoardInfo(100);
		assertEquals("First Title", findVO.getTitle());
	}
	
	//@Test
	void boardInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("title");
		vo.setWriter("sss");
		int result = mapper.insertBoardInfo(vo);
		assertTrue(result == 1);
	}
	//@Test
	void boardUpdate() {
		BoardVO findVO = mapper.selectBoardInfo(100);
		findVO.setTitle("modiTitle");
		int result = mapper.updateBoardInfo(findVO);
		assertTrue(result == 1);
	}
	//@Test
	void boardDelete() {
		int result = mapper.deleteBoardInfo(101);
		assertTrue(result == 1);
	}
}
