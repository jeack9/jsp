package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	// 전체 부서조회
	public List<DeptVO> deptList();
	// 부서 단건조회
	public DeptVO deptInfo(Integer deptId);
	// 부서 단건등록 ==> return 등록된 department_id
	public int deptInsert(DeptVO deptVO);
	// 부서 단건수정
	public Map<String, Object> deptUpdate(DeptVO deptVO);
	// 부서 단건삭제
	public Map<String, Object> deptDelete(Integer deptId);
}
