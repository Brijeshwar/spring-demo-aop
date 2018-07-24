package com.luv2code.aopdemo.around.service;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.DemoConfig;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: ArroundApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
	}
}
