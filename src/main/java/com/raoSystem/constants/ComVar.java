package com.raoSystem.constants;
import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ComVar {
	public static String conn="";
	public static Connection Conn = null;
	public static ResultSet prst = null;
	public static String sqlpstmt= "";
    public static Statement pstmt = null;
 	public static CallableStatement myStat = null;	
}
