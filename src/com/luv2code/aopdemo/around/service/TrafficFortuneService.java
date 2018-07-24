package com.luv2code.aopdemo.around.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		//Simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//return a fortune ... use this approach with caution
		return "Expect heavy traffice this morning!!";
	}
	
	public String getFortune(boolean tripWire) {
		
		
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		
		//return a fortune ... use this approach with caution
		return getFortune();
	}
}
