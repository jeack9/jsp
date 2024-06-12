package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BoardService svc = new BoardServiceImpl();
		
		BoardVO board = new BoardVO();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		if(svc.insertBoard(board)) {
			System.out.println("게시글 등록..");
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("게시글 등록실패!");
			resp.sendRedirect("boardList.do");
		}
	}

}
