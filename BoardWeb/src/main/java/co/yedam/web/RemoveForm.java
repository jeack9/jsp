package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class RemoveForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		int currPage = Integer.parseInt(req.getParameter("page"));
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(boardNo);
		req.setAttribute("board", board);
		req.setAttribute("currPage", currPage);
		
		req.getRequestDispatcher("board/removeForm.tiles").forward(req, resp);
	}

}
