package com.luv2code.aopdemo.dao.pointcut.combined;

import org.springframework.stereotype.Component;

@Component
public class MembershipPointcutCombinedDAO {

	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING STUFF ADDING A SILLY MEMBER USING POINTCUT");
		return true;
	}
	
	public void goToSleep() {
		System.out.println("I AM GOING TO SLEEP");
	}
}
