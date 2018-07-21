package com.luv2code.aopdemo.aspect.pointcut.combined;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectPointcutCombined {

	// Create a pointcut
	@Pointcut("execution(* com.luv2code.aopdemo.dao.pointcut.combined.*.*(..))")
	private void forDaoPackage() {	}

	// Create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.pointcut.combined.*.get*(..))")
	private void forGetter() {	}

	// Create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.pointcut.combined.*.set*(..))")
	private void forSetter() {	}

	// Create pointcut inclued package... but exclude getter/setter 
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	private void forDaoPackageNoGetterSetter() {	}

	//lets start with @Before advice
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API Analytics");
	}
}
