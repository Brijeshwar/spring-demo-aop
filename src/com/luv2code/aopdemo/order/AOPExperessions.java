package com.luv2code.aopdemo.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPExperessions {

	// Create a pointcut
	@Pointcut("execution(* com.luv2code.aopdemo.order.*.*(..))")
	public void forDaoPackage() {	}

	// Create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.order.*.get*(..))")
	public void forGetter() {	}

	// Create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.order.*.set*(..))")
	public void forSetter() {	}
	
	// Create pointcut inclued package... but exclude getter/setter
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	public void forDaoPackageNoGetterSetter() {	}
	
}
