package com.luv2code.aopdemo.order;

import org.springframework.stereotype.Component;

@Component
public class MembershipPointcutCombinedDAOOrder {

	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING STUFF ADDING A SILLY MEMBER USING POINTCUT ORDER");
		return true;
	}
	
	public void goToSleep() {
		System.out.println("I AM GOING TO SLEEP");
	}
}
