package com.luv2code.aopdemo.readjoinpoint;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@After("execution(* com.luv2code.aopdemo.readjoinpoint.AccountReadMethodSigAndArgs.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on the method: " + method);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.readjoinpoint.AccountReadMethodSigAndArgs.findAccounts(..))"
			, returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on the method: " + method);

		System.out.println("\n=====>>> Result is: " + result);

		// let's post-process the data ... let's modify it
		// convert account names to uppercase
		converAccountNameToUpperCase(result);
		
		System.out.println("\n=====>>> Result is: " + result);
	}

	// add a new advice for @AfterThrowing on the findAccounts method
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.readjoinpoint.AccountReadMethodSigAndArgs.findAccounts(..))"
			, throwing = "theExec")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExec) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on the method: " + method);

		System.out.println("\n=====>>> Exception is: " + theExec);
	}

	private void converAccountNameToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

	// lets start with @Before advice
	@Before("com.luv2code.aopdemo.readjoinpoint.AOPReadMethodSigAndArgExperessions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");

		// Display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);

		// Display the method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();
		System.out.println("args: " + args + ", size: " + args.length);

		// loog through args
		for (Object object : args) {
			System.out.println("object: " + object);

			if (object instanceof Account) {
				// downcast and print account specific stuff
				Account account = (Account) object;

				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}

}
