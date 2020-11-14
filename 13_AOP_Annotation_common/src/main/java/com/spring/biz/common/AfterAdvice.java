package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// (실습) @Aspect , @Pointcut , @After 적용

@Service
@Aspect
public class AfterAdvice {
	
	// 어드바이스 메서드
	// 어드바이스 동작시점 설정 + 포인트컷 지정
	@After("PointcutCommon.getPointcut()")
	public void afterLog() {
		System.out.println("[후처리-AfterAdvice.afterLog()]"
				+ " 비즈니스 로직 수행후 로그");
	}
}
