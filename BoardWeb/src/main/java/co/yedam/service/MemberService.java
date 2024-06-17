package co.yedam.service;

import co.yedam.vo.MemberVO;

public interface MemberService {
	boolean joinMember(MemberVO member);

	MemberVO checkMember(String id, String pw);
}
