package com.EZ.aop.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect // root 에서 aop:aspect
@Component
public class GoWorkAdvice {
	@Pointcut("execution(* com.EZ.aop..*ServiceImpl.CheckLogin(..))")
	
	public void implPointCut() {}
		@After("implPointCut()")
		//aop:pointcut 의 id 값이 메소드 명
	
	public void printGoWorkTime() {
		System.out.println("출근");
	}
}
