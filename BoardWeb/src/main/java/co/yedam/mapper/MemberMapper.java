package co.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO member);
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
}
