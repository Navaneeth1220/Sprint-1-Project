package com.cg.tms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Report {
	@GeneratedValue
	@Id
	private int reportId;
	
	private String reportName;
	private String reportType;

	public Report() {
	}
	public Report (String reportname, String reporttype) {
		this.reportName = reportname;
		this.reportType = reporttype;
	}
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportid) {
		this.reportId = reportid;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportname) {
		this.reportName = reportname;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reporttype) {
		this.reportType = reporttype;
	}
	
	
	

}
