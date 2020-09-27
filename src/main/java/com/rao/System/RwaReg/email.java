package com.rao.System.RwaReg;

public class email {

	public static void main(String[] args) {

		String emailId = "RAMA@GMAIL.COM";
		String rwacode="MK108";
		String emailValid = HDAORwa.validateEmail(emailId,rwacode);
		System.out.println("Step 4: HDAO OK" + emailValid );
		
	}

}
