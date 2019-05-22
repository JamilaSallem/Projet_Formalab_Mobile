package com.example.jamila.projet_formalab_mobile;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {

    TextView signup,fpass;
    EditText username,password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn=findViewById(R.id.btn_SignIn);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname=username.getText().toString();
                String mdp=password.getText().toString();
                ProjectManagementDB db=new ProjectManagementDB(LoginActivity.this);
                boolean existe=db.Connect(uname,mdp);
                if(existe){
                    Intent intent=new Intent(LoginActivity.this,ActivityList.class);
                    intent.putExtra("username",uname);
                    intent.putExtra("password",mdp);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Verify username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

