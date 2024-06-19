package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;

public class CheckIdAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		MemberService svc= new MemberServiceImpl();
		if(svc.checkMemberId(id)) { // {"retCode": "Exist"}
			resp.getWriter().print("{\"retCode\": \"Exist\"}");
		}else { // {"retCode": "Not Exist"}
			resp.getWriter().print("{\"retCode\": \"Not Exist\"}");
		}
	}

}
