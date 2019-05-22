package com.example.jamila.projet_formalab_mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProjectManagementDB extends SQLiteOpenHelper {

    private static final String DB_NAME= "dbproject";
    private static final String TB_NAME= "project";
    private static final String TB_NAME1= "employee";
    private static final int VERSION= 1;


    public ProjectManagementDB( Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create ="CREATE TABLE "+TB_NAME+" ( id integer PRIMARY KEY , username VARCHAR(30) , password VARCHAR(30) );";
        db.execSQL(create);

        String create1 ="CREATE TABLE "+TB_NAME1+" ( id integer PRIMARY KEY , title VARCHAR(30) );";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
