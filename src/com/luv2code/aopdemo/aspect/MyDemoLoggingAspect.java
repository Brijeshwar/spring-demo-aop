package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//Add all of our related advices for logging
	
	
	//lets start with @Before advice
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")//any method named as addAccount under com.luv2code.aopdemo.dao.AccountDAO class only and accessmodifier is public return type is public
//	@Before("execution(public void addAccount())") //any method named as addAccount and accessmodifier is public return type is public
//	@Before("execution(public void add*())") //any method start with add and accessmodifier is public return type is public
//	@Before("execution(public void updateAccount())") // will not call because no updateAccount() method exists
//	@Before("execution(void add*())") // only void return type
//	@Before("execution(* add*())") //any return type
//	@Before("execution(* add*(com.luv2code.aopdemo.Account))") // only one argument with com.luv2code.aopdemo.dao.AccountDAO type
//	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") //after account any no of argument
//	@Before("execution(* add*(..))") // any parameter
//	@Before("execution(public void addAccount(..))")//zero to any no of argument with any type
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // any method under dao package with any parameter
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}
