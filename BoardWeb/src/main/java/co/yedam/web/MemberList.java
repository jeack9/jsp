package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;

public class MemberList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService svc = new MemberServiceImpl();
		req.setAttribute("memberList", svc.memberList());
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
	}

}
