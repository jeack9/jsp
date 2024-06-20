package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class RemoveReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글번호 -> 댓글삭제. 반환: retCode:OK, retCode:NG{"retCode": "OK"}
		resp.setContentType("text/json;charset=utf-8");
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		
		Map<String, Object> map = new HashMap<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		if(svc.removeReply(Integer.parseInt(rno))) {
			map.put("retCode", "OK");
			map.put("retMsg", "삭제성공..");
			map.put("rno", rno);
			String json = gson.toJson(map);
			resp.getWriter().print(json);
//			resp.getWriter().print("{\"retCode\": \"OK\", \"rno\": \"" + rno + "\"}");
		}else {
			map.put("retCode", "NG");
			map.put("retMsg", "처리 실패!");
			String json = gson.toJson(map);
			resp.getWriter().print(json);
//			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	}

}
