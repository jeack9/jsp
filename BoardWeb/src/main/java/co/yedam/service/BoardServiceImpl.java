package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	@Override
	public List<BoardVO> boardList(int page) {
		return mapper.boardListPaging(page);
	}
	
	@Override
	public int boardTotal() {
		return mapper.getTotalCnt();
	}
	
	@Override
	public boolean insertBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo) == 1;
	}

	@Override
	public boolean updateBoard(BoardVO bvo) {
		return mapper.updateBoard(bvo) == 1;
	}

	@Override
	public boolean deleteBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

	@Override
	public BoardVO getBoard(int bno) {
		return mapper.getBoard(bno);
	}

}
