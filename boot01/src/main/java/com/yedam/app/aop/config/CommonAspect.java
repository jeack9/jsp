package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yedam.app.emp.service.EmpVO;

@Aspect //AOP 설정
@Component
public class CommonAspect {
	// 포인트 컷 : 조인포인트 중에서 Advice이 적용될 경로
	@Pointcut("within(com.yedam.app.emp.service.impl.*)")
	public void empPointCut() {}

	// Weaving : 포인트 컷 + 타이밍 + Advice
	@Before("empPointCut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		String signatureStr = joinPoint.getSignature().toString();
		Object[] args = joinPoint.getArgs();
		System.err.println("###### 실행 : " + signatureStr);
		for(Object arg : args) {
			System.err.print("매개변수 ");
			if(arg instanceof Integer) {
				System.err.println((Integer)arg);
			}else if(arg instanceof EmpVO) {
				System.err.println((EmpVO)arg);
			}
		}
	}
	@Around("empPointCut()")
	public Object excuteItem(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toString();
		
		System.out.println("=== 시작 : " + signatureStr);
		// 공통 기능
		System.out.println("=== 핵심 기능 전 실행 : " + System.currentTimeMillis());
		
		try {
			// 비즈니스 메소드 실행
			Object obj = joinPoint.proceed();
			return obj;
//			return new Object();
		} finally {
			// 공통기능
			System.out.println("=== 핵심 기능 후 실행: " + System.currentTimeMillis());
			System.out.println("=== 끝 : " + signatureStr);
		}
	}
}
