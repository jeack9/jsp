package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	//전체조회
	public List<DeptVO> deptList();
	//단건조회
	public DeptVO deptInfo(int deptId);
	//등록
	public int insertDept(DeptVO deptVO);
	//수정
	public int updateDept(DeptVO deptVO);
	//삭제
	public int deleteDept(int deptId);
}
