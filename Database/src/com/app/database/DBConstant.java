package com.app.database;

public class DBConstant {
	public static String databaseName="MyDatabase";
	public static String tableName="studentInfo";
	public static String rollNumber="roll";
	public static String name="name";
	public static int versionCode=1;
	public static String createQuery="CREATE TABLE "+tableName+" ("+rollNumber+" INT AUTO_INCREMENT PRIMARY KEY,"+name+" VARCHAR(200));";
	public static String deleteQuery="DROP TABLE IF EXISTS "+databaseName;	
}
