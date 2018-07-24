package com.luv2code.aopdemo.around.service;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingForAroundAspect {
	
	private static Logger myLogger = Logger.getLogger(MyDemoLoggingForAroundAspect.class.getName());

	@Around("execution(* com.luv2code.aopdemo.around.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		//Print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on the method: " + method);
		
		//get the begin timestamp
		long begin = System.currentTimeMillis();
		
		Object result = null;
		try {
			//now let's execute the method
			result = proceedingJoinPoint.proceed();
		} catch (Exception ex) {
			//
			myLogger.warning("@Around advice: We have a problem " + ex);
			
			//handle and give default fortune ... use this apporach with caution
			//result = "Nothing exciting here. Move along!";
			
			//rethrow exception
			throw ex;
		}
		
		//get the end timestamp
		long end = System.currentTimeMillis();
		
		//complete duration and display it
		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
}
