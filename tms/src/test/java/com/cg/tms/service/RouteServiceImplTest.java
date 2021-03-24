package com.cg.tms.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Route;
import com.cg.tms.repository.IRouteRepository;
@ExtendWith(MockitoExtension.class)

public class RouteServiceImplTest {
	@Mock
	IRouteRepository repository;
	
	@Spy
	@InjectMocks
	RouteServiceImpl service;
	
	/*
	 * Success Scenario
	 */
	
	@Test
	public void testAddRoute1() {
		Route route = new Route("R1","Jaipur","Chennai",(LocalDate.of(2021,04,16)),"Jaipur International Airport", 5665.5);
		Mockito.when(repository.save(route)).thenReturn(route);
		Route testRoute= service.addRoute(route);
		Assertions.assertNotNull(testRoute);
		Assertions.assertEquals("R1",testRoute.getRouteId());
		Assertions.assertEquals("Jaipur",testRoute.getRouteFrom());
		Assertions.assertEquals("Chennai",testRoute.getRouteTo());
		Assertions.assertEquals((LocalDate.of(2021,04,16)),testRoute.getDoj());
		Assertions.assertEquals("Jaipur International Airport",testRoute.getPickupPoint());
		Assertions.assertEquals(5665.5,testRoute.getFare());
	}

   /*
    * Failure Scenario	
    */
	
	@Test
	public void testAddRoute2() {
		Route route = new Route("R1","Jaipur","Bengaluru",(LocalDate.of(2021,04,16)),"Jaipur International Airport", 5665.5);
		Mockito.when(repository.save(route)).thenReturn(route);
		Route testRoute= service.addRoute(route);
		Assertions.assertNotNull(testRoute);
		Assertions.assertEquals("R1",testRoute.getRouteId());
		Assertions.assertEquals("Jaipur",testRoute.getRouteFrom());
		Assertions.assertEquals("Chennai",testRoute.getRouteTo());
		Assertions.assertEquals((LocalDate.of(2021,04,16)),testRoute.getDoj());
		Assertions.assertEquals("Jaipur International Airport",testRoute.getPickupPoint());
		Assertions.assertEquals(5665.5,testRoute.getFare());
	}

	
	/*
	 * Testing zero argument customer
	 */
   @Test
   public void testAddRoute3() {
	   Route route = new Route();
	   Mockito.when(repository.save(route)).thenReturn(route);
	   Route testRoute= service.addRoute(route);
		Assertions.assertEquals(testRoute,route);
	   
	   
   }
	}


