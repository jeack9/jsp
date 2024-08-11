package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class DeptController {
	private DeptService dsvc;

	@GetMapping("/deptList")
	public String deptList(Model model) {
		List<DeptVO> list = dsvc.deptList();
		model.addAttribute("depts", list);
		return "dept/list";
	}

	// 단건조회 : get
	@GetMapping("deptInfo")
	public String empInfo(Model model, Integer deptId) {
		DeptVO findVO = dsvc.deptInfo(deptId);
		model.addAttribute("dept", findVO);
		return "dept/info";
	}

	// 등록 - 페이지 : GET
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}

	// 등록 - 처리 : POST => form태그를 통한 submit
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int deptId = dsvc.deptInsert(deptVO);
		String url = null;
		if (deptId > -1) {
			url = "redirect:deptInfo?deptId=" + deptId;
		} else {
			url = "redirect:deptList";
		}
		return url;
	}

	// 수정 - 페이지 : Get <=> 단건조회
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Integer deptId, Model model) {
		DeptVO findVO = dsvc.deptInfo(deptId);
		model.addAttribute("dept", findVO);
		return "dept/update";
	}

	// 수정 - 처리 : AJAX => QueryString
	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> deptUpdateAJAXQueryString(DeptVO deptVO) {
		return dsvc.deptUpdate(deptVO);
	}

	// 수정 - 처리 : AJAX => JSON
	@PostMapping("deptUpdateJson")
	@ResponseBody
	public Map<String, Object> empUpdateAJAXJSON(@RequestBody DeptVO deptVO) {
		return dsvc.deptUpdate(deptVO);
	}

	// 삭제 - 처리 : GET
	@GetMapping("deptDelete")
	public String deptDelete(Integer deptId) {
		dsvc.deptDelete(deptId);
		return "redirect:deptList";
	}

}
