package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class UpdateBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BoardService svc = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		int page = Integer.parseInt(req.getParameter("page"));
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		String redir = "boardList.do?page=" + page + "&searchCondition="//
						+ sc + "&keyword=" + kw;
		if(svc.updateBoard(board)) {
			System.out.println("게시글 업데이트..");
			resp.sendRedirect(redir);
		}else {
			System.out.println("게시글 업데이트 실패");
			resp.sendRedirect("boardList.do");
		}
	}

}
