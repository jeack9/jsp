package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class GetBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		BoardVO board = svc.getBoard(boardNo);
		req.setAttribute("board", board);
		
		String currPage = req.getParameter("page");
		req.setAttribute("page", currPage);
		
		req.getRequestDispatcher("board/getBoard.tiles").forward(req, resp);
//		System.out.println(svc.getBoard(boardNo).toString());
	}

}
