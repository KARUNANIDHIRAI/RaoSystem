package com.raoSystem.FLTOWN;

import com.raoSystem.Utility.Utilities;

public class TestClass {

	public static void main(String[] args) {

		String erMsg = "ErrNo:2627;	ErrSeverity:14;ErrState: 1; ErrLine: 34; "
					  + "ErrMessage: Violation of PRIMARY KEY constraint ";	
		String erMsg1 = "1";	
		System.out.println(erMsg.length());

		/*
		 * System.out.println(erMsg.substring(6,10)); System.out.println("error NO:"
		 * +erMsg.substring(erMsg.indexOf("ErrNo:")+6,
		 * erMsg.indexOf("ErrSeverity:")-2));
		 * System.out.println("error Msg:"+erMsg.substring(erMsg.indexOf("ErrMessage:")+
		 * 11, erMsg.length()-2)); int sqlerr = SQLerNo(erMsg); String sqlerMsg =
		 * SQLerMsg(erMsg); System.out.println(sqlerr); System.out.println(sqlerMsg);
		 */
		
		/*
		 * String spStatus="1"; if(Utilities.SQLerNo(spStatus)==2) {
		 * System.out.println("2 spstatus:" ); }else { String hDAOMessage=
		 * spStatus.length()==1?"Record Created Successfully.":spStatus;
		 * System.out.println("hDAOMessage" + hDAOMessage); }
		 */

	}
}
