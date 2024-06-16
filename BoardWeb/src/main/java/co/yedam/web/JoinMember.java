package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class JoinMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService svc = new MemberServiceImpl();
		
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String respons = req.getParameter("responsibility");
		
		MemberVO member = new MemberVO(userId, userPw, userName, respons);
		
		if(svc.joinMember(member)) {
			req.setAttribute("message", "가입 성공..");
			resp.sendRedirect("loginForm.do");
		}else {
			req.setAttribute("message", "가입 실패!");
			resp.sendRedirect("joinForm.do");
		}
		
	}

}
