package com.raoSystem.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendOtpSMS {

	public static void main(String[] args) {
		Utilities getOTP = new Utilities();
		String otpStr = getOTP.GetOTP(5);
		System.out.println("OTP Generted :" + otpStr);
		SendOtpSMS.sendSMS(otpStr);
	}
	public static void sendSMS(String optStr) {
		try {
			String apiKey = "apiKey="+ "lwZ4yfeecHY-HsN6snLSFg1DBHGIDTN2qEgne61k4o";
			String message = "&message=" + URLEncoder.encode("Your OPT is : " +  optStr, "UFT-8");
			String numbers = "&numbers="+ "9811557160";
			String apiURL =  "https://api.textlocal.in/send/?" + apiKey + message + numbers;
			URL url = new URL(apiURL);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			BufferedReader bReader = new BufferedReader ( new InputStreamReader(connection.getInputStream()));
			String line= "";
			StringBuilder sb = new StringBuilder();
			while ((line = bReader.readLine())!=null) {
				sb.append(line).append("\n");
			}
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Technical Error Trap (UnsupportedEncodingException): \n" + e);
		} catch (MalformedURLException e) {
			System.out.println("Technical Error Trap (MalformedURLException): \n" + e);
		} catch (Exception e) {
			System.out.println("Technical Error Trap: \n" + e);
		}
	}
}
