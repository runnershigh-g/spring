package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.Signature;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	// 어드바이스 메서드
	// 어드바이스 동작시점 설정 + 포인트컷 지정
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		 String methodName = jp.getSignature().getName(); // 실행 될 메서드명
		Object[] args = jp.getArgs();
		System.out.println("args : " + Arrays.toString(args)); 
		
		System.out.println("[사전처리] " + methodName + "() 메서드 " 
				+ ", args정보 : " + args[0] +  " - 비지니스 로직 수행 전 로그");
	}
}
