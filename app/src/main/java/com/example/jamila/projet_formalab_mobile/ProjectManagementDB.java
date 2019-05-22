package com.example.jamila.projet_formalab_mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
        String delete=" DROP TABLE IF EXISTS "+TB_NAME;
        db.execSQL(delete);
        onCreate(db);

        String delete1=" DROP TABLE IF EXISTS "+TB_NAME1;
        db.execSQL(delete);
        onCreate(db);
    }

    public void AjoutProjet(Project projet)
    {
        SQLiteDatabase db =getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title",projet.getTitre());
        db.insert(TB_NAME,null,values);
    }

    public boolean Connect(String uname,String mdp)
    {
        String query=" SELECT * FROM "+TB_NAME1+";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        boolean found=false;
        if(cursor.moveToFirst())
        {
            do {

                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));

                if(username==uname && password==mdp)
                    found=true;

            }while (cursor.moveToNext()&&!found);
        }
        return found;
    }

    public void AjoutEmploye(Employee employe)
    {
        SQLiteDatabase db =getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",employe.getName());
        values.put("lastname",employe.getLastname());
        values.put("username",employe.getUsername());
        values.put("password",employe.getPassword());
        db.insert(TB_NAME1,null,values);
    }

    public ArrayList<Project> getProjects()
    {
        ArrayList<Project> projets = new ArrayList<>();

        String query=" SELECT * FROM "+TB_NAME+";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                Project projet = new Project();

                projets.add(projet);

            }while (cursor.moveToNext());
        }

        return projets;
    }

    public Project getProjectById(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query=" SELECT * FROM "+TB_NAME+" WHERE id = "+id;
        Cursor cursor = db.rawQuery(query,null);
        Project projet =null ;
        if (cursor.moveToFirst())
        {
            String titre=cursor.getString(cursor.getColumnIndex("title"));
            projet=new Project(id,titre);
        }

        return projet;
    }

    public Project UpdateProject(Project projet)
    {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title",projet.getTitre());

        db.update(TB_NAME,values,"id=?",new String[]{String.valueOf(projet.getId())});

        return projet;
    }

    public void DeleteProject(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TB_NAME,"id=?",new String[]{String.valueOf(id)});

    }
}
