package com.luv2code.aopdemo.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAspect {

	@Before("com.luv2code.aopdemo.order.AOPExperessions.forDaoPackageNoGetterSetter()")
	public void loggingToCloud() {
		System.out.println("\n=====>>> Logging to Cloud in async fashion");
	}
}
