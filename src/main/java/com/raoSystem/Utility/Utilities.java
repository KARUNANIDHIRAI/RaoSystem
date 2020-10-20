package com.raoSystem.Utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.raoSystem.constants.ComVar;


public class Utilities {
	public String GetOTP(int otpength) {
		String captcha ="0123456789";
		StringBuffer captchBuffer = new StringBuffer();
		Random random = new Random();
		while (captchBuffer.length()<otpength) {
			int index = (int) (random.nextFloat()*captcha.length());
			captchBuffer.append(captcha.substring(index,index+1));
		}
		return captchBuffer.toString();
	}
	public static Date conDate(String DateString) {
		DateFormat convDate = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("DateString: "+ DateString);
		Date cDate = null;
		try {
			 cDate = convDate.parse(DateString);
				System.out.println("DateString: "+ DateString);
			 System.out.println("cDate  : " + cDate);
		} catch (ParseException e) {
			System.out.println("ParseException: "+ e);
		}  		
		return cDate;
	}
	
	
}
