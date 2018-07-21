package com.luv2code.aopdemo.readjoinpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountReadMethodSigAndArgs {
	
	private String name;
	private String serviceCode;
	
	//add a new method: findAccounts()
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		
		myAccounts.add(new Account("John", "Silver"));
		myAccounts.add(new Account("Madhu", "Platinum"));
		myAccounts.add(new Account("Luca", "Gold"));
		
		return myAccounts;
	}
	
	public void addAccount(Account account, boolean isTrue) {
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
