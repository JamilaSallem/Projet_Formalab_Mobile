package com.example.jamila.projet_formalab_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProject extends AppCompatActivity {


    EditText title;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        title= findViewById(R.id.addtitle);
        submit= findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titre = title.getText().toString();

                Project projet=new Project(titre);
                ProjectManagementDB db=new ProjectManagementDB(AddProject.this);
                db.AjoutProjet(projet);

                Toast.makeText(AddProject.this, "saved !", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddProject.this,ActivityList.class);
                startActivity(intent);
            }

        });
    }
}
