package com.raoSystem.password;

import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class SendOTP {

	public boolean  uidSend(String emailid, String UID) throws EmailException {
		boolean uid = false;
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(" KARUNANIDHIRAIG@GMAIL.COM", "$Iasofficer2016$"));
		email.setSSLOnConnect(true);
		email.setSubject("OTP");
		email.setFrom("KARUNANIDHIRAIG@GMAIL.COM");
		email.addTo(emailid );
		email.setMsg(""
				+ "Hi, \n"
				+""
				+ "please find enclosed here with your Login ID: "+ UID + " to access the Application using password"
				+ ""
				+ "\n"
				+ "\n Thanks & Regards"
				+ "\n"
				+ "\n KBS TECHNOLOGY "
				+ "\n Mobile No: 9811557160")
				;

		email.send();
		uid = true;
		System.out.println("UID Sent" +UID + " mail sent to " +emailid);
		return uid;
	}
	
	 static String OTPGeneratet(int otpength) {
		String captcha ="0123456789";
		StringBuffer captchBuffer = new StringBuffer();
		Random random = new Random();
		while (captchBuffer.length()<otpength) {
			int index = (int) (random.nextFloat()*captcha.length());
			captchBuffer.append(captcha.substring(index,index+1));
		}
		return captchBuffer.toString();
	}
	
		public String  emailsend(String emailid) throws EmailException {
			String otpcode=OTPGeneratet(4);
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(" KARUNANIDHIRAIG@GMAIL.COM", "$Iasofficer2016$"));
			email.setSSLOnConnect(true);
			email.setSubject("OTP");
			email.setFrom("KARUNANIDHIRAIG@GMAIL.COM");
			email.addTo(emailid );
			email.setMsg(""
					+ "Hi, \n"
					+""
					+ "please find enclosed here with your Password reset security Confirmation OTP Code "
					+ otpcode
					+ ""
					+ "\n"
					+ "\n Thanks & Regards"
					+ "\n"
					+ "\n KBS TECHNOLOGY  \n"
					+ "\n Mobile No: 9811557160")
					;

			email.send();
			System.out.println("otp Sent" +otpcode + " mail sent to " +emailid);
			return otpcode;
		}	 
}
