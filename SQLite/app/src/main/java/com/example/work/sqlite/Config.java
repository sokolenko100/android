package com.example.work.sqlite;

/**
 * Created by work on 12.03.2017.
 */

public class Config
{
    public static final String DB_name = "PersonDB";
    public static final String Table_name = "Person";
    public static final int DB_version = 1;
    public static final String command_Crate = "create table IF NOT EXISTS "+ Table_name +" ("
            +MyObjectContruct._ID +" INTEGER PRYMERY KEY, "
            +MyObjectContruct.Name +" TEXT, "
            +MyObjectContruct.SurName +" TEXT, "
            +MyObjectContruct.AGE +" INTEGER" +");";
    public static final String command_Delete = "drop table IF EXISTS "+ Table_name;

}
