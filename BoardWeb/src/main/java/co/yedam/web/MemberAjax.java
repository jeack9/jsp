package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberAjax implements Control {

//	@ResponseBody
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//		
		resp.setContentType("text/json;charset=UTF-8");
		// {"name":"홍길동", "age":20, "phone":"010-2222-222"}
		
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		String json = "[";
		int idx = 0;
		for(MemberVO member : list) {
			json += "{\"userId\":\"" + member.getUserId() + "\"," + "\"userName\":\"" + member.getUserName() + "\"," + "\"userPw\":\"" + member.getUserPw()
					+  "\"," + "\"responsibility\":\"" + member.getResponsibility() + "\"}";
			if(idx < list.size() - 1) {
				json += ",";
			}
			idx++;
		}
		json += "]";
		resp.getWriter().print(json);
	}

}
