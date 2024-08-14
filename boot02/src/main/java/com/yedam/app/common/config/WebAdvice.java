package com.yedam.app.common.config;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WebAdvice {
	//@ExceptionHandler : 특정 예외에 대한 처리 등록
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<String> handleSqlException() { // 원본의 response 객체를 감싸는 형태로 생성시켜서 응답
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	@ModelAttribute("contextPath")
	public String contextPath(HttpServletRequest req) {
		return req.getContextPath();
	}
}
