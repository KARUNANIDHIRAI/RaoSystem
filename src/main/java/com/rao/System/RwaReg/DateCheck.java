package com.rao.System.RwaReg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateCheck {

	public static void main(String[] args) throws ParseException {


        //format() method Formats a Date into a date/time string. 
		 String testDateString = "02/04/2014";
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date d1 = df.parse(testDateString);
        System.out.println("Date: " + d1);
        System.out.println("Date: " +df.format(d1));
		
		System.out.println(" knrai :"+conDate(testDateString));
	}
	private static Date conDate(String testDateString) {
		DateFormat convDate = new SimpleDateFormat("dd/MM/yyyy");
		Date cDate = null;
		try {
			 cDate = convDate.parse(testDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  		
		return cDate;
	}
}
