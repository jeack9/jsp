package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 4개 -> DB 입력 -> ok 반환
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String duty = req.getParameter("duty");
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(name);
		mvo.setResponsibility(duty);
		
		MemberService svc = new MemberServiceImpl();
		if(svc.insertMemberAjax(mvo)) { // {"retCode": "OK", "retMsg": "Success"}
			resp.getWriter().print("{\"retCode\": \"OK\", \"retMsg\": \"Success\"}");
		}else { // {"retCode": "Fail", "retMsg": "Fail"}
			resp.getWriter().print("{\"retCode\": \"Fail\", \"retMsg\": \"Fail\"}");
		}
	}

}
