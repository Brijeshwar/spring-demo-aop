package com.luv2code.aopdemo.around.service;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.DemoConfig;

public class AroundDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: ArroundApp");
		
		myLogger.info("Calling getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
	}
}
