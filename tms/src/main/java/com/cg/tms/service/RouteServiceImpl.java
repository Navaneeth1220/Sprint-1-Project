package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.InvalidFareException;
import com.cg.tms.exceptions.InvalidRouteFromException;
import com.cg.tms.exceptions.InvalidRouteIdException;
import com.cg.tms.exceptions.InvalidRouteToException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IRouteRepository;

@Service
public class RouteServiceImpl implements IRouteService{

	@Autowired
	IRouteRepository repository;

	@Override
	public Route addRoute(Route route) {
		validateRouteId(route.getRouteId());
		validateRouteFrom(route.getRouteFrom());
		validateRouteTo(route.getRouteTo());
		validateFare(route.getFare());
		Route saved= repository.save(route);
		return saved;
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		validateRouteId(route.getRouteId());
		Optional<Route> optional = repository.findById(route.getRouteId());
		if (!optional.isPresent()) {

		throw new RouteNotFoundException("Route not found for RouteId=" +route.getRouteId());
		
		}
		Route fetched = optional.get();
		fetched.setRouteFrom(route.getRouteFrom());
		fetched.setRouteTo(route.getRouteTo());
		fetched.setFare(route.getFare());
		fetched=repository.save(route);
		return fetched;
	}

	@Override
	public Route removeRoute(String routeId) throws RouteNotFoundException {

		validateRouteId(routeId);
		Optional<Route> optional =repository.findById(routeId);
		if (!optional.isPresent()) {

			throw new RouteNotFoundException("Route not found for RouteId=" + routeId);
		}

		repository.deleteById(routeId);

		return optional.get();
	}

	@Override
	public Route searchRoute(String routeId) throws RouteNotFoundException {
		validateRouteId(routeId);
		Optional<Route> optional = repository.findById(routeId);
		if (!optional.isPresent()) {

			throw new RouteNotFoundException("Route not found for RouteId= " + routeId);
		}
		return optional.get();
	}

	
		
	

	@Override
	public List<Route> viewRouteList() {
		
		return null;
	}
	
	
	public void validateRouteId(String routeId) {
		if (routeId == null || routeId.isEmpty() || routeId.trim().isEmpty()) {

			throw new InvalidRouteIdException("Route ID can't be null or empty");
		}
		}
	
		public void validateRouteFrom(String routeFrom) {
			if (routeFrom == null || routeFrom.isEmpty() || routeFrom.trim().isEmpty()) {

				throw new InvalidRouteFromException("RouteFrom can't be null or empty");
			}

	}
		public void validateRouteTo(String routeTo) {
			if (routeTo == null || routeTo.isEmpty() || routeTo.trim().isEmpty()) {

				throw new InvalidRouteToException("RouteTo can't be null or empty");
			}	
}
		public void validateFare(double fare) {
			if(fare<0) {
				throw new InvalidFareException("Fare can't be negative");
			}
		}
}