package com.cg.tms.repository;

import java.util.List;

import java.util.Optional;



import com.cg.tms.entities.Route;

public interface IRouteRepository {
	
	Route save(Route route);
	Optional<Route> findById(String routeId);
	void deleteById (String routeId);
	
	
	/*public  Route  addRoute(Route route);
	public  Route  updateRoute(Route route) throws RouteNotFoundException;
	public  Route   removeRoute(int routeId) throws RouteNotFoundException;
	public  Route    searchRoute(int routeId) throws RouteNotFoundException;
	public  List<Route> viewRouteList();*/
	
	
	
	

}
