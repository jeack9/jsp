package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ThymeleafController {
	private EmpService esvc;
	
	@GetMapping("thymeleaf")
	public String thymeleafTest(Model model) {
		EmpVO findVO = esvc.empInfo(100);
		model.addAttribute("empInfo", findVO);
		
		return "test";
	}
}
