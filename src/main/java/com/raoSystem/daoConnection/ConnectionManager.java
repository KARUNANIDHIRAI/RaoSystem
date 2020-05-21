package com.raoSystem.daoConnection;

import java.sql.*;
import java.util.*;
public class ConnectionManager {
	static Connection con;
	static String dburl;
	static String uid;
	static String pwd;
	static String Conurl;
	static String db2017url;
	public static Connection getConnection() {
		try {
//	        String Conurl= "jdbc:sqlserver://localhost;databaseName=GangaRWA;user=knsa;password=sakn12"; 
//	        db2017url= "jdbc:sqlserver://localhost:SQLEXPRESS01;Database=GangaRWA;user=sa;password=secret;";
			//Connection conn = DriverManager.getConnection(dburl,uid,pwd)		
	        dburl    = "jdbc:sqlserver://localhost;databaseName=raoSystem"; 
	        uid = "sa";
	        pwd = "knsa";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try	{            	
				con = DriverManager.getConnection(dburl,uid,pwd); 
			}
			catch (SQLException ex)	{
				System.out.println("Error in create database connection:");
				ex.printStackTrace();
			}
		}
		catch(ClassNotFoundException e)	{
			System.out.println("Error in :Class.forName");
			System.out.println(e);
		}
		return con;
	}
}



/*
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.SQLException;
 * 
 * public class ConnectionManager { static Connection conn;
 * 
 * static String dburl; static String uid; static String pwd; static String
 * Conurl; static String db2017url;
 * 
 * 
 * public enum Environment {
 * dburl("jdbc:sqlserver://localhost;databaseName=raoSystem"),uid( "sa"),
 * pwd("knsa"), ForClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 * 
 * private String eurl;
 * 
 * Environment(String envUrl) { this.eurl = envUrl; }
 * 
 * public String getUrl() { return eurl; } }
 * 
 * 
 * public static Connection getConnection() { try {
 * 
 * String Conurl=
 * "jdbc:sqlserver://localhost;databaseName=raoSystem;user=sa;password=knsa";
 * db2017url=
 * "jdbc:sqlserver://localhost:SQLEXPRESS01;Database=GangaRWA;user=sa;password=secret;";
 * dburl = "jdbc:sqlserver://localhost;databaseName=GangaRWA"; uid = "sa"; pwd =
 * "knsa"; dburl="jdbc:sqlserver://localhost;databaseName=raoSystem";
 * 
 * 
 * dburl="jdbc:sqlserver://localhost:SQLEXPRESS;databaseName=raoSystem"; uid=
 * "sa"; pwd="knsa";
 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 * System.out.println("Connection variable declared success"); // //
 * Class.forName(Environment.ForClassName.getUrl()); try { // con =
 * DriverManager.getConnection(Environment.dburl.getUrl(),Environment.uid.getUrl
 * (),Environment.pwd.getUrl()); conn =
 * DriverManager.getConnection(dburl,uid,pwd);
 * 
 * System.out.println("\n Successfull connection created"); }catch (SQLException
 * ex) { System.out.println("Error in create connection:");
 * ex.printStackTrace(); } }catch(ClassNotFoundException e) {
 * System.out.println(e); } return conn; }
 * 
 * }
 */