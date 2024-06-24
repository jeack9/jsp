package co.yedam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private String responsibility;
	private String image;
}
