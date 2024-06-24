package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class JoinMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일첨부일 경우에는 multipart 요청을 처리.
		// Multipart 요청(1.요청정보, 2.저장위치, 3.최대크기, 4.인코딩방식, 5.리네임정책)
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5; // 5mb
		String encoding = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		MemberService svc = new MemberServiceImpl();
		
		String userId = mr.getParameter("userId");
		String userPw = mr.getParameter("userPw");
		String userName = mr.getParameter("userName");
		String respons = mr.getParameter("responsibility");
		String img = mr.getFilesystemName("myImage");
				
		MemberVO member = new MemberVO(userId, userPw, userName, respons, img);
		
		try {
			if(svc.joinMemberImage(member)) {
//			req.setAttribute("message", "가입 성공..");
//			resp.sendRedirect("loginForm.do");
				resp.sendRedirect("memberList.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
