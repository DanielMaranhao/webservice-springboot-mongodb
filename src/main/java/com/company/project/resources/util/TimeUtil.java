package com.company.project.resources.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public final class TimeUtil {

	private TimeUtil() {}
	
	public static Instant toInstant(String date) {
		return LocalDate.parse(date).atStartOfDay(ZoneId.of("GMT")).toInstant();
	}
}
