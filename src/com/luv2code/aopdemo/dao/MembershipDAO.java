package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ":DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}
	
//	public void addSillyMember() {
//		System.out.println("MembershipDAO.addSillyMember()");
//	}
	
	public boolean addSillyMember() {
		System.out.println("MembershipDAO.addSillyMember()");
		return true;
	}
	
	public void goToSleep() {
		System.out.println("MembershipDAO.goToSleep()");
	}
}
