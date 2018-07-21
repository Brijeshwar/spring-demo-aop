package com.luv2code.aopdemo.readjoinpoint;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.DemoConfig;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountReadMethodSigAndArgs theAccountPointcutCombinedDAOOrder = context.getBean("accountReadMethodSigAndArgs", AccountReadMethodSigAndArgs.class);
		
		List<Account> accountList = null;
		try {
			//add a boolean flag to simulate the exception
			boolean tripWire = true;
			
			accountList = theAccountPointcutCombinedDAOOrder.findAccounts(tripWire);
		} catch(Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}
		
		System.out.println("\n\nMain program: AfterThrowingDemoApp");
		System.out.println("----");
		
		System.out.println(accountList);
		
		System.out.println("\n");
		
		//close the context
		context.close();
	}
}
