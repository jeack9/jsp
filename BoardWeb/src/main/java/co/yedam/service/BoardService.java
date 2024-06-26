package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;

// 기능의 실행은 mapper 실행
public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int boardTotal(SearchVO search);
	boolean insertBoard(BoardVO bvo);
	boolean updateBoard(BoardVO bvo);
	boolean deleteBoard(int bno);
	BoardVO getBoard(int bno);
	
	// checkMember(id,pw)
	boolean checkMember(String id, String pw);
}
