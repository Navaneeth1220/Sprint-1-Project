package com.cg.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IRouteRepository;

@Service
public class RouteServiceImpl implements IRouteService{

	@Autowired
	IRouteRepository repository;
	@Transactional
	@Override
	public Route addRoute(Route route) {
		Route route1= repository.save(route);
		return route1;
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		
		return null;
	}

	@Override
	public Route removeRoute(int routeId) throws RouteNotFoundException {

		return null;
	}

	@Override
	public Route searchRoute(int routeId) throws RouteNotFoundException {
		
		return null;
	}

	@Override
	public List<Route> viewRouteList() {
		
		return null;
	}
	
	
	
	
	

	

	

}
