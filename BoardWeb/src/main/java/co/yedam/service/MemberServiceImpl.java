package co.yedam.service;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.MemberMapper;
import co.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public boolean joinMember(MemberVO member) {
		return mapper.insertMember(member) == 1;
	}

	@Override
	public MemberVO checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

}
