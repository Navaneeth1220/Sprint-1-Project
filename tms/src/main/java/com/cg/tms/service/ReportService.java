package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.exceptions.InvalidReportException;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.repository.IReportRepository;

@Service
public class ReportService implements IReportService {

	@Autowired
	private IReportRepository repository;

	@Override
	public Report addReport(Report report) {
		validateReportType(report.getReportType());
		validateReportName(report.getReportName());
		return repository.save(report);

	}

	void validateReportName(String reportName) {
		if (reportName == null || reportName.isEmpty() || reportName.trim().isEmpty()) {
			throw new InvalidReportException("Check Report Name");
		}

	}

	void validateReportType(String reportType) {
		if (reportType == null || reportType.isEmpty() || reportType.trim().isEmpty()) {
			throw new InvalidReportException("Check Report Type");
		}

	}

	@Override
	public Report deleteReport(int reportId) throws ReportNotFoundException {
		validateId(reportId);
		Optional<Report> optional = repository.findById(reportId);
		if (!optional.isPresent()) {
			throw new ReportNotFoundException("Report not found");
		}
		Report fetched = optional.get();
		repository.delete(fetched);
		return fetched;

	}

	void validateId(int reportId) {
		if (reportId < 0) {
			throw new InvalidIdException("ID cannot be negative");
		}

	}

	@Override
	public Report viewReport(int reportId) throws ReportNotFoundException {
		Optional<Report> optional = repository.findById(reportId);
		if (!optional.isPresent()) {
			throw new ReportNotFoundException("Report not found");
		}
		return optional.get();
	}

	@Override
	public List<Report> viewAllReports() {
		List<Report> reports = repository.findAll();
		return reports;
	}

}
