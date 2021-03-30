package com.cg.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.tms.ManualTesting.ReportManualTest;




@SpringBootApplication
public class TripBookingBoot {
	
	public static void main(String args[]) {
	
	ConfigurableApplicationContext context = SpringApplication.run(TripBookingBoot.class, args);
	//HotelUI room = context.getBean(HotelUI.class);
	ReportManualTest room = context.getBean(ReportManualTest.class);
	room.start();
	}
}