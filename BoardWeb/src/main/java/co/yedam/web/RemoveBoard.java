package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		int page = Integer.parseInt(req.getParameter("page"));
		BoardService svc = new BoardServiceImpl();
		if(svc.deleteBoard(boardNo)) {
			System.out.println("삭제 성공..");
			resp.sendRedirect("boardList.do?page=" + page);
		}else {
			System.out.println("삭제 실패!");
		}
	}

}
