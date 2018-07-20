package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT WITH ACCOUNT ARGUMENT");
	}
	
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT WITH TWO ARGUMENT");
	}
	
	public boolean doWork() {
		System.out.println("AccountDAO.doWork()");
		return false;
	}
}
