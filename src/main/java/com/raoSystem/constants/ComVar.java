package com.raoSystem.constants;
import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ComVar {
	public static String conn="";
	public static String sqlpstmt= "";
	public static Connection Conn = null;
	public static ResultSet prst = null;
    public static Statement pstmt = null;
 	public static CallableStatement myStat = null;
 	public static CallableStatement callableStat = null;
    public static Session sessionObj;
	public static SessionFactory sessionFactoryObj;
	
	public static void disposeConnection(Connection Conn,CallableStatement myStat, ResultSet prst) {
		if (ComVar.prst != null) {
			try {
				ComVar.prst.close();
			} catch (Exception e) {
			}
			ComVar.prst = null;
		}
		if (ComVar.myStat != null) {
			try {
				ComVar.myStat.close();
			} catch (Exception e) {
			}
			ComVar.myStat = null;
		}
		if (ComVar.Conn != null) {
			try {
				ComVar.Conn.close();
			} catch (Exception e) {
			}
			ComVar.Conn = null;
		}
	}
	
 	
}
