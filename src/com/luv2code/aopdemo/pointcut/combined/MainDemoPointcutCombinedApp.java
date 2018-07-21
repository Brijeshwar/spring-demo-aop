package com.luv2code.aopdemo.pointcut.combined;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.DemoConfig;
import com.luv2code.aopdemo.dao.pointcut.combined.AccountPointcutCombinedDAO;
import com.luv2code.aopdemo.dao.pointcut.combined.MembershipPointcutCombinedDAO;

public class MainDemoPointcutCombinedApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountPointcutCombinedDAO theAccountPointcutCombinedDAO = context.getBean("accountPointcutCombinedDAO", AccountPointcutCombinedDAO.class);
		
		//Get membership bean from spring container
		MembershipPointcutCombinedDAO theMembershipPointcutCombinedDAO = context.getBean("membershipPointcutCombinedDAO", MembershipPointcutCombinedDAO.class);
		
		//call the business method
		theAccountPointcutCombinedDAO.addAccount();
		theAccountPointcutCombinedDAO.doWork();
		
		//call the getter and setter
		theAccountPointcutCombinedDAO.setName("foobar");
		theAccountPointcutCombinedDAO.setServiceCode("silver");
		
		String name = theAccountPointcutCombinedDAO.getName();
		String code = theAccountPointcutCombinedDAO.getServiceCode();
		
		//call the membership business method
		theMembershipPointcutCombinedDAO.addSillyMember();
		theMembershipPointcutCombinedDAO.goToSleep();
		
		//close the context
		context.close();
	}
}
