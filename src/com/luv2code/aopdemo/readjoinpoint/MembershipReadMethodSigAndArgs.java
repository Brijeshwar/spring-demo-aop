package com.luv2code.aopdemo.readjoinpoint;

import org.springframework.stereotype.Component;

@Component
public class MembershipReadMethodSigAndArgs {

	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING STUFF ADDING A SILLY MEMBER USING POINTCUT ORDER");
		return true;
	}
	
	public void goToSleep() {
		System.out.println("I AM GOING TO SLEEP");
	}
}
