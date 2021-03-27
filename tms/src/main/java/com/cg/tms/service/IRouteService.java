package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;

public interface IRouteService {
	
	
	
	public  Route  addRoute(Route route);
	public  Route  updateRoute(Route route) throws RouteNotFoundException;
	public  Route   removeRoute(String routeId) throws RouteNotFoundException;
	public  Route    searchRoute(String routeId) throws RouteNotFoundException;
	public  List<Route> viewRouteList();
	
	
	
	

}
