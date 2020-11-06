package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//(실습) @Aspect , @Pointcut , @Around 적용

@Service
@Aspect
public class AroundAdvice {
	
	// 포인트컷 작성 : 명칭은 메서드명을 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Around("PointcutCommon.getPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("[Around BEFORE] 비지니스 로직 실행 전 처리");
				Object returnObj = pjp.proceed(); // 실행 할 (될) 메서드 동작 시키기
		System.out.println("[Around AFTER] 비지니스 로직 실행 후 처리");
		
		stopWatch.stop();
		
		System.out.println("[ around ]" + methodName + "() 메서드 " 
				+ ", 실행시간 : " + stopWatch.getTotalTimeMillis() + "밀리초 (ms)");
		
		
		return returnObj;
	}
}
