package com.xml.zig.zigbackapp.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyDateConverter {
	
	public static String getDateFromMilliseconds(String millisec) {
		DateFormat obj = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");   
		Long date = Long.parseLong(millisec);
		Date res = new Date(date);   
		return obj.format(res);
	}
}
