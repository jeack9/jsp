package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		
		MemberVO mvo = svc.checkMember(id, pw);
		
		if(mvo != null) {
			HttpSession session = req.getSession();
			session.setAttribute("logid", id);
			if(mvo.getResponsibility().equals("User")) resp.sendRedirect("main.do");
			else resp.sendRedirect("memberList.do");
		}else {
			resp.sendRedirect("loginForm.do");
		}
	}

}
