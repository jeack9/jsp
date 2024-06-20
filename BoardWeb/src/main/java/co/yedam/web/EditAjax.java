package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class EditAjax implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserName(name);
		mvo.setUserPw(pass);
		MemberService svc = new MemberServiceImpl();
		
		if(svc.editMember(mvo)) { // {"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	}

}
