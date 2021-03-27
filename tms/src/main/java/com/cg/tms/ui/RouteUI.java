package com.cg.tms.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Route;
import com.cg.tms.service.IRouteService;

@Component
public class RouteUI {

	@Autowired
	private IRouteService service;

	public void start() {
		Route route1=new Route();
        Route route2= new Route();
        route1.setRouteId("R1");
        route1.setRouteFrom("Jaipur");
        route1.setRouteTo("Delhi");
        route1.setFare(600);
        route2.setRouteId("R2");
        route2.setRouteFrom("Delhi");
        route2.setRouteTo("Himachal");
        route2.setFare(600);
        route1= service.addRoute(route1);
        route2= service.addRoute(route2);
        display(route1);
        display(route2);
        route1.setRouteId("R1");
        route1.setRouteFrom("Jaipur");
        route1.setRouteTo("Himachal");
        route1.setFare(1200);
        route1=service.updateRoute(route1);
        display(route1);
        Route route3 = service.searchRoute("R2");
        display(route3);
        List<Route> list = new ArrayList<>();
        list.add(route1);
        list.add(route2);
        list = service.viewRouteList();
        System.out.println(Arrays.toString(list.toArray()));
	}

	public void display(Route route) {
		System.out.println("Route Id = "+ route.getRouteId());
		System.out.println("Route From = "+ route.getRouteFrom());
		System.out.println("Route To = "+ route.getRouteTo());
		System.out.println("Route Fare = "+ route.getFare());
		
	}

}
