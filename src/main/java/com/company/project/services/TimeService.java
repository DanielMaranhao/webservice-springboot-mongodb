package com.company.project.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public final class TimeService {

	private TimeService() {}
	
	public static Instant toInstant(String date) {
		return LocalDate.parse(date).atStartOfDay(ZoneId.of("GMT")).toInstant();
	}
}
