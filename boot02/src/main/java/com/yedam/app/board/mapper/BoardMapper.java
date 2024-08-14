package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체
	public List<BoardVO> selectBoardAll();
	// 단건 - 조건: bno
	public BoardVO selectBoardInfo(Integer bno);
	// 등록 - 대상: bno, title, contents, writer, regdate, updatedate, image - title, writer, regdate 필수값
	public int insertBoardInfo(BoardVO boardVO);
	// 수정 - 대상: title, contents, writer, regdate, updatedate, image - title, writer, regdate 필수값
	public int updateBoardInfo(BoardVO boardVO);
	// 삭제 - 조건: bno
	public int deleteBoardInfo(Integer bno);
}