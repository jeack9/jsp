package co.yedam.service;

import java.util.List;

import co.yedam.vo.MemberVO;

public interface MemberService {
	boolean joinMember(MemberVO member);

	MemberVO checkMember(String id, String pw);
	
	List<MemberVO> memberList();
	
	boolean insertMemberAjax(MemberVO member);
	
	boolean checkMemberId(String id);
	
	boolean removeMember(String id);

	boolean editMember(MemberVO mvo);
}
