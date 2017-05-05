package com.example.bsc.csitoldquestioncollection;

public class DbConstant {
	public static int VERSION_CODE=1;
	public static String DATABASE_NAME="SITES";
	public static String TABLE_NAME="mysite";
	public static String YEAR="year";
	public static String SITE="site";
	public static String CREATE_QUERY="CREATE TABLE "+TABLE_NAME+" ("+YEAR+" INT, "+SITE+" VARCHAR(300));";
	public static String DELETE_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
}
