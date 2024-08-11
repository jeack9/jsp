package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@SpringBootTest
public class DeptTest {
	@Autowired
	DeptMapper mapper;
	
//	@Test
	void deptList() {
		List<DeptVO> list = mapper.deptList();
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	void deptInfo() {
		DeptVO findVO = mapper.deptInfo(220);
		assertEquals("NOC", findVO.getDepartmentName());
	}
	
	//@Test
	void insertDept() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentName("testDept");
		int result = mapper.insertDept(vo);
		assertTrue(result == 1);
	}
	
	//@Test
	void updateDept() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentId(271);
		vo.setDepartmentName("transDept");
		int result = mapper.updateDept(vo);
		assertTrue(result == 1);
	}
	
	//@Test
	void deleteDept() {
		int result = mapper.deleteDept(271);
		assertTrue(result == 1);
	}
}
