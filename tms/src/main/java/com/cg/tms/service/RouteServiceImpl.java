package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Route;

import com.cg.tms.exceptions.InvalidRouteException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IRouteRepository;

@Service
public class RouteServiceImpl implements IRouteService {

	@Autowired
	private IRouteRepository repository;

	@Override
	public Route addRoute(Route route) {
		validateRoute(route);
		Route saved = repository.save(route);
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
		Optional<Route> optional = repository.findById(routeId);
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
		List<Route> routeList = repository.findAll();
		return routeList;
	}

	void validateRoute(Route route) {
		validateRouteId(route.getRouteId());
		validateRouteFrom(route.getRouteFrom());
		validateRouteTo(route.getRouteTo());
		validateFare(route.getFare());
	}

	public void validateRouteId(String routeId) {
		if (routeId == null || routeId.isEmpty() || routeId.trim().isEmpty()) {

			throw new InvalidRouteException("Route ID can't be null or empty");
		}
	}

	public void validateRouteFrom(String routeFrom) {
		if (routeFrom == null || routeFrom.isEmpty() || routeFrom.trim().isEmpty()) {

			throw new InvalidRouteException("RouteFrom can't be null or empty");
		}

	}

	public void validateRouteTo(String routeTo) {
		if (routeTo == null || routeTo.isEmpty() || routeTo.trim().isEmpty()) {

			throw new InvalidRouteException("RouteTo can't be null or empty");
		}
	}

	public void validateFare(double fare) {
		if (fare < 0) {
			throw new InvalidRouteException("Fare can't be negative");
		}
	}
}