package com.luv2code.aopdemo.order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.DemoConfig;

public class MainDemoPointcutCombinedOrderApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountPointcutCombinedDAOOrder theAccountPointcutCombinedDAOOrder = context.getBean("accountPointcutCombinedDAOOrder", AccountPointcutCombinedDAOOrder.class);
		
		//Get membership bean from spring container
		MembershipPointcutCombinedDAOOrder theMembershipPointcutCombinedDAOOrder = context.getBean("membershipPointcutCombinedDAOOrder", MembershipPointcutCombinedDAOOrder.class);
		
		//call the business method
		theAccountPointcutCombinedDAOOrder.addAccount();
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
