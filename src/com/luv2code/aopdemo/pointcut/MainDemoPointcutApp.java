package com.luv2code.aopdemo.pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.DemoConfig;
import com.luv2code.aopdemo.dao.pointcut.AccountPointcutDAO;
import com.luv2code.aopdemo.dao.pointcut.MembershipPointcutDAO;

public class MainDemoPointcutApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountPointcutDAO theAccountPointcutDAO = context.getBean("accountPointcutDAO", AccountPointcutDAO.class);
		
		//Get membership bean from spring container
		MembershipPointcutDAO theMembershipPointcutDAO = context.getBean("membershipPointcutDAO", MembershipPointcutDAO.class);
		
		//call the business method
		theAccountPointcutDAO.addAccount();
		theAccountPointcutDAO.doWork();
		
		//call the membership business method
		theMembershipPointcutDAO.addSillyMember();
		theMembershipPointcutDAO.goToSleep();
		
		//close the context
		context.close();
	}
}
