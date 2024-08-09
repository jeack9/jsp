package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;




@Controller
@RequestMapping("/emp")
public class EmpController {
	
	private EmpService esvc;
	
	@Autowired
	public EmpController(EmpService esvc){
		this.esvc = esvc;
	}
	
	@GetMapping("empList")
	public String empList(Model model){
		// 1) 해당 기능 수행
		List<EmpVO> list = esvc.empList();
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("emps", list);
		return "emp/list"; // 3) 데이터를 출력할 페이지 결정
	}
	
	// 단건조회 : get
	@GetMapping("empInfo")
	public String empInfo(Model model, @RequestParam(defaultValue="100") Integer empId) {
		EmpVO findVO = esvc.empInfo(empId);
		model.addAttribute("emp", findVO);
		return "emp/info";
	}
	
	// 등록 - 페이지 : GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	// 등록 - 처리 : POST => form태그를 통한 submit
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = esvc.empInsert(empVO);
		String url = null;
		if(eid > -1) {
			url = "redirect:empInfo?empId=" + eid;
		}else {
			url = "redirect:empList";
		}
		return url;
	}
	
	// 수정 - 페이지 : Get <=> 단건조회
	@GetMapping("empUpdate")
	public String empUpdateForm(Integer empId, Model model) {
		EmpVO findVO = esvc.empInfo(empId);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}
	
	// 수정 - 처리 : AJAX => QueryString
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateAJAXQueryString(EmpVO empVO) {
		return esvc.empUpdate(empVO);
	}
	
	// 수정 - 처리 : AJAX => JSON
	@PostMapping("empUpdateJson")
	@ResponseBody
	public Map<String, Object> empUpdateAJAXJSON(@RequestBody EmpVO empVO) {
		return esvc.empUpdate(empVO);
	}
	
	
	// 삭제 - 처리 : GET
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		esvc.empDelete(empId);
		return "redirect:empList";
	}
	
}