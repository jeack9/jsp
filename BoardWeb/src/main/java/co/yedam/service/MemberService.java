package co.yedam.service;

import java.util.List;

import co.yedam.vo.MemberVO;

public interface MemberService {
//	boolean joinMember(MemberVO member);
	
	// 파일첨부 회원등록.
	boolean joinMemberImage(MemberVO mvo);

	MemberVO checkMember(String id, String pw);
	
	List<MemberVO> memberList();
	
	boolean insertMemberAjax(MemberVO member);
	
	boolean checkMemberId(String id);
	
	boolean removeMember(String id);

	boolean editMember(MemberVO mvo);
}
