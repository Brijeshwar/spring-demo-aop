package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//Get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		theAccountDAO.addAccount(new Account());
		theAccountDAO.addAccount(new Account(), true);
		theAccountDAO.doWork();
		
		//call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();
	}
}
