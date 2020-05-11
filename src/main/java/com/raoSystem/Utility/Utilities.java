package com.raoSystem.Utility;

import java.util.Random;


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
	
	
}
