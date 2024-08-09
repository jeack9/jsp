package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest // 테스트환경 IoC 컨테이너 생성
class Boot01ApplicationTests {
	@Autowired
	EmpMapper empMapper;
	
	//@Test
	void empList() { // 전체조회
		List<EmpVO> list = empMapper.selectAllList();
		assertTrue(!list.isEmpty());
	}

	//@Test
	void empInfo() { // 단건조회
		EmpVO findVO = empMapper.selectEmpInfo(100);
		assertEquals("King", findVO.getLastName());
	}
	
	//@Test
	void insertEmp() {
		EmpVO vo = new EmpVO();
		vo.setLastName("testName");
		vo.setEmail("test@email.com");
		vo.setJobId("IT_PROG");
		int result = empMapper.insertEmpInfo(vo);
		assertTrue(result == 1);
	}
	
	//@Test
	void updateEmp() {
		EmpVO vo = new EmpVO();
		vo.setLastName("ads");
		vo.setJobId("AD_PRES");
		vo.setSalary(24000);
		int result = empMapper.updateEmpInfo(4321, vo);
		assertTrue(result == 1);
	}
	
	//@Test
	void deleteEmp() {
		int result = empMapper.deleteEmpInfo(4321);
		empMapper.deleteEmpInfo(4322);
		assertEquals(1, result);
	}
}
