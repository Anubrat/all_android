package com.app.databasefinale;

public class DbConstants {
	public static String DB_NAME="Databases";
	public static String TABLE_NAME="MyTable";
	public static String _NAME="name";
	public static String _ID="id";
	public static int VERSION_CODE=5;
	public static String QUERY="CREATE TABLE "+TABLE_NAME+" ("+_ID+" int AUTO_INCREMENT PRIMARY KEY, "+_NAME+" varchar(200));";	
	public static String DELETE_QUERY="DROP TABLE IF EXISTS "+TABLE_NAME;
}
