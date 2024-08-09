package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	
	private EmpMapper empMapper;
	
	@Autowired
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	
	@Override
	public List<EmpVO> empList() {
		return empMapper.selectAllList();
	}

	@Override
	public EmpVO empInfo(Integer empId) {
		return empMapper.selectEmpInfo(empId);
	}

	@Override
	public int empInsert(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isSuccessed = false;
		int result = empMapper.updateEmpInfo(empVO.getEmployeeId(), empVO);
		isSuccessed = result == 1 ? true : false;
		map.put("result", isSuccessed);
		map.put("target", empVO);
		return map;
	}

	@Override
	public Map<String, Object> empDelete(int empId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int result = empMapper.deleteEmpInfo(empId);
		if(result == 1) {
			map.put("employeeId", empId);
		}
		
		return map;
	}
	
}
