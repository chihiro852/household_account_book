package com.example.householdAccountBook.utility;

public class DateFormatUtility {
	// yyyyMMddをyyyy/MM/dd
	public static String DateFormatSlash(String accountDate) {
		String date = "";
		if (accountDate == "") {
			return date;
		} else {
			date = accountDate.substring(0, 4) + "/" + accountDate.substring(4, 6) + "/"
					+ accountDate.substring(6, 8);
			return date;
		}
	}

	// yyyy/MM/ddをyyyy-MM-dd
	public static String DateFormatSlashToHyphen(String accountDate) {
		String date = "";
		if (accountDate == "") {
			return date;
		} else {
			date = accountDate.replace("/", "-");
			return date;
		}
	}

	// yyyy-MM-ddをyyyyMMdd
	public static String DateFormatHyphenToBlank(String accountDate) {
		String date = "";
		if (accountDate == "") {
			return date;
		} else {
			date = accountDate.replace("-", "");
			return date;
		}
	}
}