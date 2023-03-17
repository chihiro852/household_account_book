package com.example.householdAccountBook.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeFormatUtility {
	public String yyyyMMdd(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		String changeDate = format.parse(date).toString();

		return changeDate;
	}
}