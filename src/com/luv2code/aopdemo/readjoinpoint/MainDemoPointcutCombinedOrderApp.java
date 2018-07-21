package com.luv2code.aopdemo.readjoinpoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.DemoConfig;

public class MainDemoPointcutCombinedOrderApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountReadMethodSigAndArgs theAccountPointcutCombinedDAOOrder = context.getBean("accountReadMethodSigAndArgs", AccountReadMethodSigAndArgs.class);
		
		//Get membership bean from spring container
		MembershipReadMethodSigAndArgs theMembershipPointcutCombinedDAOOrder = context.getBean("membershipReadMethodSigAndArgs", MembershipReadMethodSigAndArgs.class);
		
		//call the business method
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		
		theAccountPointcutCombinedDAOOrder.addAccount(account, true);
		theAccountPointcutCombinedDAOOrder.doWork();
		
		//call the getter and setter
		theAccountPointcutCombinedDAOOrder.setName("foobar");
		theAccountPointcutCombinedDAOOrder.setServiceCode("silver");
		
		String name = theAccountPointcutCombinedDAOOrder.getName();
		String code = theAccountPointcutCombinedDAOOrder.getServiceCode();
		
		//call the membership business method
		theMembershipPointcutCombinedDAOOrder.addSillyMember();
		theMembershipPointcutCombinedDAOOrder.goToSleep();
		
		//close the context
		context.close();
	}
}
