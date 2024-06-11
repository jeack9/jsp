package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class DeleteBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		if(svc.deleteBoard(boardNo)) {
			System.out.println(boardNo + "번 게시글 삭제..");
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("게시글 삭제 실패!");
			resp.sendRedirect("boardList.do");
		}
	}

}
