package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO member);
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	
	public List<MemberVO> memberList();
	public int insertMemberAjax(MemberVO member);
	
	public int selectMemberAjax(String id);
	public int deleteMemberAjax(String id);
	public int updateMemberAjax(MemberVO mvo);
}
