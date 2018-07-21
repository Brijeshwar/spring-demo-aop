package com.luv2code.aopdemo.dao.pointcut;

import org.springframework.stereotype.Component;

@Component
public class AccountPointcutDAO {

	public void addAccount() {
		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT USING POINTCUT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
