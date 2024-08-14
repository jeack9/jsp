package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
public class AopTests {
	@Autowired
	AaaService asvc;
	
	//@Test
	void transactionalTest() {
		asvc.aaaInsert();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void pwdEncoderTest() {
		String pwd = "1234";
		String enPwd = passwordEncoder.encode("1234");
		System.out.println(enPwd);
		boolean result = passwordEncoder.matches(pwd, enPwd);
		System.out.println(result);
	}
}
