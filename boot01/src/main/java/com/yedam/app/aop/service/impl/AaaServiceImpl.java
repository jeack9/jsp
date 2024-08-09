package com.yedam.app.aop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AaaServiceImpl implements AaaService{
	private AaaMapper aaaMapper;
	
	@Override
	@Transactional
	public void aaaInsert() {
		aaaMapper.aaaInsert("101");
		aaaMapper.aaaInsert("a101");
	}
	
}
