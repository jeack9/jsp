package co.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.CenterVO;
import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	
	@Override
	public List<ReplyVO> replyList(int boardNo) {
		return mapper.selectList(boardNo);
	}

	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReplay(replyNo);
	}

	@Override
	public boolean registerReply(ReplyVO rvo) {
		return mapper.insertReply(rvo) == 1;
	}

	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}

	@Override
	public List<ReplyVO> replyListPaging(int boardNo, int page) {
		return mapper.selectListPaging(boardNo, page);
	}

	@Override
	public int getTotalCnt(int bno) {
		return mapper.selectReplyCnt(bno);
	}

	@Override
	public int createCenterInfo(CenterVO[] arr) {
		return mapper.insertCenter(arr);
	}

	@Override
	public List<Map<String, Object>> centerList() {
		return mapper.centerBySido();
	}

}
