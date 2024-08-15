package com.EZ.aop.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Aspect
@Component
public class StopWatchAdvice {
	@Pointcut("execution(* com.EZ.aop..*Controller.*(..))")
	
	public void allPointCut() {}
	@Around("allPointCut()")
	
	public Object checkTime(ProceedingJoinPoint pp) throws Throwable  {
		String methodName = pp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pp.proceed();
		stopWatch.stop();
		System.out.println(methodName+"() 메소드 수행에 걸린시간:"
		+stopWatch.getTotalTimeMillis()+"(ms)");
		return obj;
	}
}
