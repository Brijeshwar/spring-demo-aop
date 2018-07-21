package com.luv2code.aopdemo.aspect.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectPointcut {

	// Create a pointcut
	@Pointcut("execution(* com.luv2code.aopdemo.dao.pointcut.*.*(..))")
	private void forDaoPackage() {	}

	//lets start with @Before advice
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Executing @Before advice on performApiAnalytics()");
	}
}
