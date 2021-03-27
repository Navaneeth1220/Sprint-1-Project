package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Report;

public interface IReportRepository extends JpaRepository<Report,Integer>   {

	
	
	/*	public Report  addReport(Report report);
		public Report  deleteReport(int reportId) throws ReportNotFoundException;
		public Report  viewReport(int reportId) throws ReportNotFoundException;
		public Report  viewAllReports();
		*/
	
}
