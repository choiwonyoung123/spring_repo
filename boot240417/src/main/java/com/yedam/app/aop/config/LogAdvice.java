package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // aop기반 동작하는 대상, aop를 위해 따로 관리(별도 설정 파일)
@Component // bean 등록
public class LogAdvice {
	// 포인트컷 = 비즈니스 로직과 관련된 메소드 중에서 어드바이스가 적용될 메소드 선언
	@Pointcut("within(com.yedam.app.emp.service.impl.*)")
	public void allPointCut() {} // 포인트컷 불러내기
	
	// weaving = 포인트컷 + 어드바이스 + 타이밍
	@Around("allPointCut()") // 포인트컷 적용
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable { // 실행 >> proceeding 필요
		// aop 적용되는 메소드의 이름
		String signatureStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatureStr);
		
		// 공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능 : " + System.currentTimeMillis());
		try {
			Object obj = joinPoint.proceed(); // 실제 비즈니스 파일 실행 >> 어떤타입인지 정확하지 않기 때문에 Object 타입으로 반환하기
			return obj;
		}finally { // 끝날때 무조건 실행
			System.out.println("핵심 기능 후 실행 - 공통기능 : " + System.currentTimeMillis());
			System.out.println("끝 : " + signatureStr);
		}
	}
	
	@Before("allPointCut()")
	public void beforeAdvice(JoinPoint joinPoint) { // 실행x >> proceeding 필요x
		String signatureStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatureStr);
	}
	
}
