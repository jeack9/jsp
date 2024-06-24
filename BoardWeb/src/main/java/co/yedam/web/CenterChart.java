package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class CenterChart implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=UTF-8");
		ReplyService svc = new ReplyServiceImpl();
		List<Map<String, Object>> result = svc.centerList();
		
		Map<String, Object> centerMap = new HashMap<String, Object>();
		
		for(Map<String, Object> map : result) {
			System.out.println(map.get("sido").getClass().getName() + " - " + map.get("cnt").getClass().getName());
			System.out.println("-----------------------------");
			centerMap.put((String)map.get("sido"), map.get("cnt"));
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(centerMap);
		resp.getWriter().print(json);
		
	}

}
