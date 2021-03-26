package com.cg.tms.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {
	
	@Id
	private String routeId;
	private String  routeFrom;
	private String  routeTo;
//	private  List<Bus> buses;
	private  LocalDateTime  departureTime;
	private  LocalDateTime   arrivalTime;
	private  LocalDate   doj;
	private String pickupPoint;
	private  double fare;
	
	

}
