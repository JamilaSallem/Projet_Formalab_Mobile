package com.example.jamila.projet_formalab_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    ListView list;
    ProjectManagementDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = findViewById(R.id.list);

        db = new ProjectManagementDB(this);
        ArrayList<Project> projectArrayList = db.getProjects();

        final AdapterClass adapter = new AdapterClass(this,projectArrayList);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add)
        {
            Intent intent = new Intent(ActivityList.this,AddProject.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

}

