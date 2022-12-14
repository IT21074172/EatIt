package com.jscreations.myloginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText email, password;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


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


        loginbtn = findViewById(R.id.loginbtn1);



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                authenticateUser();
            }
        });

    }

    private  void  authenticateUser(){

        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        String eml = email.getText().toString();
        String pass = password.getText().toString();

        if(TextUtils.isEmpty(eml) || TextUtils.isEmpty(pass))
            Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
        mAuth.signInWithEmailAndPassword(eml, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

                            if (user.isEmailVerified()){

                                startActivity(new Intent(MainActivity.this, ProfilePage.class));
                            }else {
                                user.sendEmailVerification();
                                Toast.makeText(MainActivity.this, "Check your email to verify your account", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}