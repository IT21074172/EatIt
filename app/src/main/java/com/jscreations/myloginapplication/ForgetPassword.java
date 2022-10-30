package com.jscreations.myloginapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPassword extends AppCompatActivity {

    EditText password, password1, password2;
    Button resetbutton;
//    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);



        password = findViewById(R.id.oldpw);
        password1 = findViewById(R.id.newpw1);
        password2 = findViewById(R.id.newpw2);
        resetbutton = findViewById(R.id.resetbtn);
//        DB = new DBHelper(this);

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = password.getText().toString();
                String pass1 = password1.getText().toString();
                String pass2 = password2.getText().toString();

                if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(pass1) || TextUtils.isEmpty(pass2))
                    Toast.makeText(ForgetPassword.this, "Test", Toast.LENGTH_SHORT).show();
                else{

                }
            }
        });


    }
}