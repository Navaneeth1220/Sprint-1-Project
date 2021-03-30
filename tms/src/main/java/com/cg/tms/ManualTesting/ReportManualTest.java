package com.cg.tms.ManualTesting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.exceptions.InvalidReportException;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.service.IReportService;



@Component
public class ReportManualTest {
	
	@Autowired
	private IReportService service;
	
	public void start() {
		try {
			Report report= new Report();
			report.setReportName("ParisTrip");
			report.setReportType("ReportDetails");
			report.setReportId(1);
			
			Report added = service.addReport(report);
			System.out.println("Report Added");
			display(added);
			
			Report report1 = new Report();
			report.setReportName("Andaman Trip");
			report.setReportType("ReportDetails");
			report.setReportId(2);
			System.out.println("View All Reports");
			List<Report>reports = service.viewAllReports();
			displayAll(reports);
			Report view = service.viewReport(report.getReportId());
			System.out.println("View Report");
			display (view);
			Report remove = service.deleteReport(report1.getReportId());
			System.out.println("DeletedReport");
			display(remove);
		}
		catch(ReportNotFoundException e) {
			System.out.println("Report not Found");
		}
		catch (InvalidIdException e) {
			System.out.println("Id negative");
		}
		catch(InvalidReportException e) {
			System.out.println("Report Exception");
		}
	}
void displayAll(List<Report> reports) {
	for(Report report : reports) {
		display(report);
	}
		
	}
void display(Report added) {
	System.out.println(added.getReportId()+" "+added.getReportName()+" "+added.getReportType());
}

}
