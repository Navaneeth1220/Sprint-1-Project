package com.cg.tms.service;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.InvalidReportException;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.repository.IReportRepository;

@ExtendWith(MockitoExtension.class)
class ReportUnitTest {
	@Mock
	IReportRepository repository;
	
	@Spy
	@InjectMocks
	ReportService service;
	
	@Test
	void testMake_1() {

		String reportType="TripDetails";
		String reportName="ParisTrip";
		
		Report report = new Report( reportType,reportName);
		Report saved = mock(Report.class);
		Mockito.when(repository.save(report)).thenReturn(saved);
		doNothing().when(service).validateReportType(report.getReportType());
		doNothing().when(service).validateReportName(report.getReportName());
		Report result = service.addReport(report);
		
		Assertions.assertNotNull(result);
		
		Assertions.assertSame(saved,result);
		verify(repository).save(report);
	
	}
	@Test
	void testMake_2() {
		String ReportType="";
		Report report = new Report(ReportType,"TripDetails");
		Executable executable = ()->service.addReport(report);
		Assertions.assertThrows(InvalidReportException.class, executable);
		
	}
	

	@Test
	void testMake_3() {
		String ReportName="";
		Report report = new Report("ParisTrip",ReportName);
		Executable executable = ()->service.addReport(report);
		Assertions.assertThrows(InvalidReportException.class, executable);
		
	}
	
	
	
	

	//Booking Found
	@Test
	void testFind_1() throws ReportNotFoundException {
		int id=1;
		Report report = mock(Report.class);
		Optional<Report> optional = Optional.of(report);
		when(repository.findById(id)).thenReturn(optional);
		Report result = service.viewReport(id);
		Assertions.assertEquals(result, report);
	}
	
	//Booking not found
	@Test
	void testFind_2() {
		int id=3;		
		Optional<Report> optional = Optional.empty();
		when(repository.findById(id)).thenReturn(optional);
		Executable executable =()->service.viewReport(id);
		Assertions.assertThrows(ReportNotFoundException.class,executable);
		
		
		
	}
	 // Deleting success scenario 
	 
	
	@Test
	void deleteReportTest_1() {
		int id =1;
		Report report=mock(Report.class);
		Optional<Report> optional = Optional.of(report);
		Mockito.when(repository.findById(id)).thenReturn(optional);
		//Mockito.when(repository.delete(report)).thenReturn(Optional.empty());
		doNothing().when(service).validateId(id);
		doNothing().when(repository).delete(report);
		Report result = service.deleteReport(id);
		Assertions.assertNotNull(optional);
		Assertions.assertEquals(report,result);
		verify(repository).delete(result);
	}
	
	
	/*
	  Scenario id not found for deleting. Delete failed
	 */
	@Test
	void deleteReportTest_2() {
		int id=1;
		Optional<Report> optional = Optional.empty();
		when(repository.findById(id)).thenReturn(optional);
		Executable executable = () -> service.viewReport(id);
		Assertions.assertThrows(ReportNotFoundException.class, executable);
	}
	/*Scenario List of all bookings
	 */
	@Test
	void viewAllReports_Test_1() {
		List<Report> reportss = mock(List.class);
		when(repository.findAll()).thenReturn(reportss);
		List<Report> result=repository.findAll();
		Assertions.assertSame(reportss, result);
		verify(repository).findAll();
		
	}
	
	

	
	

}
