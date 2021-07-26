package com.company.project.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Instant convertMoment(String textMoment, Instant defaultValue) {
		try {
			return TimeUtil.toInstant(textMoment);
		}
		catch(DateTimeParseException e) {
			return defaultValue;
		}
		
	}
}
