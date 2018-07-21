package com.luv2code.aopdemo.order;

import org.springframework.stereotype.Component;

@Component
public class AccountPointcutCombinedDAOOrder {
	
	private String name;
	private String serviceCode;

	public void addAccount() {
		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT USING POINTCUT COMBINED ORDER");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ":in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ":in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ":in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ":in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
