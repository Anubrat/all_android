package com.mobile.app.databasemanagement;

/**
 * Created by Manandhar on 6/22/16.
 */
public class DbConstant {
    public static String name = "name";
    public static String age = "age";
    public static int VERSION = 2;
    public static String DATABASE = "nameSaving";
    public static String TABLE = "saving";
    public static String QUERY = "CREATE TABLE " +TABLE + "(" + name + " varchar(200), " + age + " varchar(10));";
    public static String DELETE_QUERY = "DROP TABLE IF EXISTS " + TABLE;
}
