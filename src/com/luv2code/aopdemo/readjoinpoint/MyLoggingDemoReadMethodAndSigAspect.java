package com.luv2code.aopdemo.readjoinpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoReadMethodAndSigAspect {

	// lets start with @Before advice
	@Before("com.luv2code.aopdemo.readjoinpoint.AOPReadMethodSigAndArgExperessions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		//Display the method signature
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		//Display the method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		System.out.println("args: " + args + ", size: " + args.length);
		
		//loog through args
		for (Object object : args) {
			System.out.println("object: " + object);
			
			if(object instanceof Account) {
				//downcast and print account specific stuff
				Account account = (Account)object;
				
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}

}
