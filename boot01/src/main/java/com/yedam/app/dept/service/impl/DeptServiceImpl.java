package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeptServiceImpl implements DeptService{

	private DeptMapper deptMapper;
	
	@Override
	public List<DeptVO> deptList() {
		return deptMapper.deptList();
	}

	@Override
	public DeptVO deptInfo(Integer deptId) {
		return deptMapper.deptInfo(deptId);
	}

	@Override
	public int deptInsert(DeptVO deptVO) {
		int result = deptMapper.insertDept(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isSuccessed = false;
		int result = deptMapper.updateDept(deptVO);
		isSuccessed = result == 1 ? true : false;
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(Integer deptId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = deptMapper.deleteDept(deptId);
		if(result == 1) {
			map.put("departmentId", deptId);
		}
		return map;
	}

}
