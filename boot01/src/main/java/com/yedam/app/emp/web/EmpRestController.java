package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
public class EmpRestController {
	private EmpService esvc;
	
//	@Autowired
//	public EmpRestController(EmpService esvc){
//		this.esvc = esvc;
//	}
	
	// 전체조회
	@GetMapping("/emps")
	public List<EmpVO> empList() {
		return esvc.empList();
	}
	
	// 단건조회
	@GetMapping("/emps/{id}")
	public EmpVO empInfo(@PathVariable(name ="id") Integer employeeId) {
		return esvc.empInfo(employeeId);
	}
	
	
	// 등록
	@PostMapping("/emps")
	public int empInsert(@RequestBody EmpVO emp) {
		return esvc.empInsert(emp);
	}
	
	
	// 수정
	@PutMapping("/emps/{id}")
	public Map<String, Object> empUpdate(@PathVariable(name="id") Integer empId, @RequestBody EmpVO emp) {
		emp.setEmployeeId(empId);
		return esvc.empUpdate(emp);
	}
	
	// 삭제
	@DeleteMapping("/emps/{empId}")
	public Map<String, Object> deleteEmp(@PathVariable Integer empId) {
		return esvc.empDelete(empId);
	}
	
}
