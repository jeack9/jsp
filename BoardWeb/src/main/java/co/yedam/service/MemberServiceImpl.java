package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.MemberMapper;
import co.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
//	@Override
//	public boolean joinMember(MemberVO member) {
//		return mapper.insertMember(member) == 1;
//	}

	@Override
	public MemberVO checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> memberList() {
		return mapper.memberList();
	}

	@Override
	public boolean insertMemberAjax(MemberVO member) {
		return mapper.insertMemberAjax(member) == 1;
	}

	@Override
	public boolean checkMemberId(String id) {
		return mapper.selectMemberAjax(id) == 1;
	}

	@Override
	public boolean removeMember(String id) {
		return mapper.deleteMemberAjax(id) == 1;
	}

	@Override
	public boolean editMember(MemberVO mvo) {
		return mapper.updateMemberAjax(mvo) == 1;
	}

	@Override
	public boolean joinMemberImage(MemberVO mvo) {
		return mapper.insertMember(mvo) == 1;
	}
	

}
