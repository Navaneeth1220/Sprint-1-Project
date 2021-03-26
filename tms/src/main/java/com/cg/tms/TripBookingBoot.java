package com.cg.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.tms.manualTesting.ServiceImplManualTesting;




@SpringBootApplication
public class TripBookingBoot {
	
	public static void main(String args[]) {
	
	ConfigurableApplicationContext context = SpringApplication.run(TripBookingBoot.class, args);
	ServiceImplManualTesting test = context.getBean(ServiceImplManualTesting.class);
	test.start();
	}
}