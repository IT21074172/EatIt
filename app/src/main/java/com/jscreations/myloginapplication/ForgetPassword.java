package com.jscreations.myloginapplication;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    private EditText email;
    private Button resetbutton;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.entrmail);
        resetbutton = findViewById(R.id.resetbtn);

        auth =FirebaseAuth.getInstance();

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpass();
            }
        });


    }
    private void resetpass(){
        String eml = email.getText().toString().trim();

        if (eml.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()){
            email.setError("PLEASE ENTER VALID EMAIL");
            email.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail(eml).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgetPassword.this, "Check your email ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ForgetPassword.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}