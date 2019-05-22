package com.example.jamila.projet_formalab_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProjectManagementDB db=new ProjectManagementDB(MainActivity.this);

        Employee employee=new Employee("Jamila","Sallem","Joe","hello");
        db.AjoutEmploye(employee);
        Employee employee1=new Employee("Wiem","Lagha","Wiwi","hi");
        db.AjoutEmploye(employee1);
        Employee employee2=new Employee("Ahmed","Salhi","Hmed","hola");
        db.AjoutEmploye(employee2);

        connect=findViewById(R.id.btn_connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
