package com.cg.tms.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.InvalidRouteFromException;
import com.cg.tms.exceptions.InvalidRouteIdException;
import com.cg.tms.exceptions.InvalidRouteToException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IRouteRepository;

@ExtendWith(MockitoExtension.class)

public class RouteServiceImplTest {
	@Mock
	IRouteRepository repository;

	@Spy
	@InjectMocks
	RouteServiceImpl service;

	/*
	 * Add Route: Success Scenario
	 */

	@Test
	public void testAddRoute1() {
		String routeId = "R1";
		String routeFrom = "Jaipur";
		String routeTo = "Delhi";
		double fare = 600;
		Route route = mock(Route.class);
		Route saved = mock(Route.class);
		when(route.getRouteId()).thenReturn(routeId);
		when(route.getRouteFrom()).thenReturn(routeFrom);
		when(route.getRouteTo()).thenReturn(routeTo);
		when(route.getFare()).thenReturn(fare);
		when(repository.save(route)).thenReturn(saved);
		doNothing().when(service).validateRouteId(routeId);
		doNothing().when(service).validateRouteFrom(routeFrom);
		doNothing().when(service).validateRouteTo(routeTo);
		doNothing().when(service).validateFare(fare);
		Route result = service.addRoute(route);
		Assertions.assertSame(saved, result);
		verify(repository).save(route);
		verify(service).validateRouteId(routeId);
		verify(service).validateRouteFrom(routeFrom);
		verify(service).validateRouteTo(routeTo);
		verify(service).validateFare(fare);
	}

	/*
	 * Add Route: Failure Scenario
	 */

	@Test
	public void testAddRoute2() {

		String routeId = "";
		Route route = mock(Route.class);
		when(route.getRouteId()).thenReturn(routeId);
		doThrow(InvalidRouteIdException.class).when(service).validateRouteId(routeId);
		Executable executable = () -> service.addRoute(route);
		Assertions.assertThrows(InvalidRouteIdException.class, executable);
		verify(repository, never()).save(route);
	}

	/*
	 * Search Route: Success Scenario
	 */
	@Test
	public void testSearchRouteById_1() {

		String routeId = "R1";
		Route route = mock(Route.class);
		Optional<Route> optional = Optional.of(route);
		when(repository.findById(routeId)).thenReturn(optional);
		doNothing().when(service).validateRouteId(routeId);
		Route result = service.searchRoute(routeId);
		Assertions.assertSame(route, result);
		verify(repository).findById(routeId);
	}

	/*
	 * Search Route: Failure Scenario
	 */
	@Test
	public void testSearchRouteById_2() {

		String routeId = "RR";
		Optional<Route> optional = Optional.empty();
		when(repository.findById(routeId)).thenReturn(optional);
		doNothing().when(service).validateRouteId(routeId);
		Executable executable = () -> service.searchRoute(routeId);
		Assertions.assertThrows(RouteNotFoundException.class, executable);
	}

	/*
	 * Remove Route: Success Scenario
	 */
	@Test
	public void testRemoveRouteById_1() {

		String routeId = "R3";
		Route route = mock(Route.class);
		Optional<Route> optional = Optional.of(route);
		when(repository.findById(routeId)).thenReturn(optional);
		doNothing().when(service).validateRouteId(routeId);
		Route result = service.removeRoute(routeId);
		Assertions.assertSame(route, result);
		verify(repository).findById(routeId);

	}

	/*
	 * Remove Route: Failure Scenario
	 */
	@Test
	public void testRemoveRouteById_2() {

		String routeId = "R90";
		Optional<Route> optional = Optional.empty();
		when(repository.findById(routeId)).thenReturn(optional);
		doNothing().when(service).validateRouteId(routeId);
		Executable executable = () -> service.removeRoute(routeId);
		Assertions.assertThrows(RouteNotFoundException.class, executable);
	}

	/*
	 * Validate Route ID: Empty
	 */

	@Test
	public void testValidateRouteId_1() {

		String routeId = "";
		Executable executable = () -> service.validateRouteId(routeId);
		Assertions.assertThrows(InvalidRouteIdException.class, executable);

	}

	/*
	 * Validate Route ID: null
	 */

	@Test
	public void testValidateRouteId_2() {

		String routeId = null;
		Executable executable = () -> service.validateRouteId(routeId);
		Assertions.assertThrows(InvalidRouteIdException.class, executable);

	}
	/*
	 * Validate Route ID: Success
	 */

	@Test
	public void testValidateRouteId_3() {

		String routeId = "R2";
		service.validateRouteId(routeId);

	}

	/*
	 * Validate Route From: Empty
	 */

	@Test
	public void testValidateRouteFrom_1() {

		String routeFrom = "";
		Executable executable = () -> service.validateRouteFrom(routeFrom);
		Assertions.assertThrows(InvalidRouteFromException.class, executable);

	}

	/*
	 * Validate Route From: null
	 */

	@Test
	public void testValidateRouteFrom_2() {

		String routeFrom = null;
		Executable executable = () -> service.validateRouteFrom(routeFrom);
		Assertions.assertThrows(InvalidRouteFromException.class, executable);

	}

	/*
	 * Validate Route From: Success
	 */

	@Test
	public void testValidateRouteFrom_3() {

		String routeFrom = "Jaipur";
		service.validateRouteFrom(routeFrom);

	}

	/*
	 * Validate Route To: Empty
	 */

	@Test
	public void testValidateRouteTo_1() {

		String routeTo = "";
		Executable executable = () -> service.validateRouteTo(routeTo);
		Assertions.assertThrows(InvalidRouteToException.class, executable);

	}

	/*
	 * Validate Route To: null
	 */

	@Test
	public void testValidateRouteTo_2() {

		String routeTo = null;
		Executable executable = () -> service.validateRouteTo(routeTo);
		Assertions.assertThrows(InvalidRouteToException.class, executable);

	}

	/*
	 * Validate Route To: Success
	 */

	@Test
	public void testValidateRouteTo_3() {

		String routeTo = "Bengaluru";
		service.validateRouteTo(routeTo);

	}

	/*
	 * Update Route: Success Scenario
	 */
	@Test
	public void testUpdateRoute() {
		String routeId = "R1";
		String routeFrom = "Delhi";
		String routeTo = "Himachal";
		double fare = 600;
		Route route = mock(Route.class);
		when(route.getRouteId()).thenReturn(routeId);
		when(route.getRouteFrom()).thenReturn(routeFrom);
		when(route.getRouteTo()).thenReturn(routeTo);
		when(route.getFare()).thenReturn(fare);
		Optional<Route> optional = Optional.of(route);
		when(repository.findById(routeId)).thenReturn(optional);
		doNothing().when(service).validateRouteId(routeId);
		when(repository.save(route)).thenReturn(route);
		Route result = service.updateRoute(route);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, route);

	}

	/*
	 * View Route List: Success Scenario
	 */
	@Test
	public void testViewRouteList() {
		List<Route> routes = mock(List.class);
		when(repository.findAll()).thenReturn(routes);
		List<Route> result = service.viewRouteList();
		Assertions.assertSame(routes, result);
		verify(repository).findAll();

	}
}
