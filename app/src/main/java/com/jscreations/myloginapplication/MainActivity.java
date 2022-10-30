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

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginbtn;
//    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.forgetpass);
        TextView textView1 = findViewById(R.id.register);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgetPassword.class);
                startActivity(intent);

            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        loginbtn = findViewById(R.id.loginbtn1);
//        DB = new DBHelper(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                else {

//                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
//                    if(checkuserpass == true){
//                    //this is from order Management
//
//                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(), Profile.class);
//                        startActivity(intent);
//                    }else {
//                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                    }
                }
            }
        });

    }
}