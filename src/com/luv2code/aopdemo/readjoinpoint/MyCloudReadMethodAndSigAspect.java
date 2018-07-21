package com.luv2code.aopdemo.readjoinpoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudReadMethodAndSigAspect {

	@Before("com.luv2code.aopdemo.readjoinpoint.AOPReadMethodSigAndArgExperessions.forDaoPackageNoGetterSetter()")
	public void loggingToCloud() {
		System.out.println("\n=====>>> Logging to Cloud in async fashion");
	}
}
