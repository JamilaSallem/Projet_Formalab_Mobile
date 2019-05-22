package com.example.jamila.projet_formalab_mobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_project extends AppCompatActivity {
    ProjectManagementDB db;
    int id;
    EditText title;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_project);

        title=findViewById(R.id.updateTitle);
        final Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        db = new ProjectManagementDB(this);
        Project projet =db.getProjectById(id);
        submit=findViewById(R.id.submit);

        title.setText(projet.getTitre());


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titre =title.getText().toString();
                Project projet=new Project(id,titre);
                db.UpdateProject(projet);
                Toast.makeText(update_project.this, "project updated ...!", Toast.LENGTH_SHORT).show();

                Intent intent1 = new Intent(update_project.this,ActivityList.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.delete)
        {
            showPopUp();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Press Yes to confirm")
                .setMessage("you want to delete this contact !!")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.DeleteProject(id);
                        Toast.makeText(update_project.this, "contact deleted", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(update_project.this,ActivityList.class);
                        startActivity(intent);
                    }

                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
