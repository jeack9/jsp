package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller // Bean 등록, web과 관련된 부분
public class URLController {
	//@RequestMapping(path = "/test", method = RequestMethod.GET)
	@GetMapping(path = "/test")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method\n Select - " + keyword;
	}
	
	@PostMapping("/test")
	@ResponseBody
	public String postMethodName(@RequestBody EmpVO empVO) {
		return empVO.getLastName();
	}
	
}
