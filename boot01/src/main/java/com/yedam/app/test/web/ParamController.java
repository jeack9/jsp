package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@CrossOrigin(origins = "*")
@Controller
public class ParamController {
	@RequestMapping(path = "comobj", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(@RequestParam Integer employeeId, String lastName, @RequestParam(name="message", defaultValue = "No message", required = true) String msg) {
		String result = "";
		result += "Path: /comobj \n";
		result += "\t employee_id : " + employeeId;
		result += "\t last_name : " + lastName;
		result += "\t msg : " + msg;
		return result;
	}
	
	@RequestMapping("path/{id}")
	@ResponseBody
	public String requestMethodName(@PathVariable String id) {
		String result = "";
		result += "path: /path/{id} \n";
		result += "\t id : " + id;
		return result;
	}
	
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody List<EmpVO> list) {
		String result = "path : /resbody \n";
		for(EmpVO vo : list) {
			result += "\t employee_id : " + vo.getEmployeeId();
			result += "\t last_name : " + vo.getLastName();
			result += "\t hire_date : " + vo.getHireDate() + "\n";
		}
		return result;
	}
	
	
}
