package com.jscreations.myloginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email,password;
    Button regbtn;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        regbtn = findViewById(R.id.regbtn);
        DB = new DBHelper(this);

        TextView textView = findViewById(R.id.logint);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String eml = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(user) ||TextUtils.isEmpty(eml) || TextUtils.isEmpty(pass))
                    Toast.makeText(RegisterActivity.this, "All Fields are Requiered", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = DB.checkusername(user);
                    if (checkuser == false){
                        Boolean insert = DB.insertData(user,eml, pass);
                        if (insert==true){
                            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ProfilePage.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "User Already Exists",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}