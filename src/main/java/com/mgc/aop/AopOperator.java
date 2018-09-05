package com.mgc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopOperator {
	
	@Pointcut("execution(* com.mgc.service.system..*.*(..))")
	public void pointCut(){}
	
	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint){
		System.out.println("AOP Before Advice...");
	}
	
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint){
		System.out.println("AOP After Advice...");
	}
	
	// 和@Around同时使用时返回结果为null
	@AfterReturning(pointcut="pointCut()", returning="returnVal")
	public void afterReturn(JoinPoint joinPoint, Object returnVal){
		System.out.println("AOP AfterReturning Advice:" + returnVal);
	}
	
	@AfterThrowing(pointcut="pointCut()", throwing="error")
	public void afterThrowing(JoinPoint joinPoint, Throwable error){
		System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
	}
	
//	@Around("pointCut()")
//	public void arount(ProceedingJoinPoint pjp){
//		System.out.println("AOP Aronud before...");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("AOP Aronud after...");
//	}
}
