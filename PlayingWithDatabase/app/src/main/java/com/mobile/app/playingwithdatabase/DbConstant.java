package com.mobile.app.playingwithdatabase;

/**
 * Created by Manandhar on 5/26/16.
 */
public class DbConstant {
    public static int VERSION_CODE=1;
    public static String TBL_NAME="TBL_STUDENT";
    public static String DB_NAME="ASMT_DB";
    public static String rollNumber="roll";
    public static String name="name";
    public static String CREATE_QUERY="CREATE TABLE "+TBL_NAME+" ("+rollNumber+" INT AUTO_INCREMENT PRIMARY KEY,"+name+" VARCHAR(200));";
    public static  String DELETE_QUERY ="DROP TABLE IF EXISTS "+DB_NAME ;
}