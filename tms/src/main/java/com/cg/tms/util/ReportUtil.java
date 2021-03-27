package com.cg.tms.util;

import org.springframework.stereotype.Component;

import com.cg.tms.entities.Report;

@Component
public class ReportUtil {
	public Report newReport() {
		return new Report();
	}

}
