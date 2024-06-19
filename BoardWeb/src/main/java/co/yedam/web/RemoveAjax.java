package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;

public class RemoveAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		if(svc.removeMember(id)) {
//			System.out.println("삭제성공");
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		}else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}

}
