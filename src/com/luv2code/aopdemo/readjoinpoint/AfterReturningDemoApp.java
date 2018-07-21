package com.luv2code.aopdemo.readjoinpoint;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.DemoConfig;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountReadMethodSigAndArgs theAccountPointcutCombinedDAOOrder = context.getBean("accountReadMethodSigAndArgs", AccountReadMethodSigAndArgs.class);
		
		List<Account> accountList = theAccountPointcutCombinedDAOOrder.findAccounts();
		
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("----");
		
		System.out.println(accountList);
		
		System.out.println("\n");
		
		//close the context
		context.close();
	}
}
