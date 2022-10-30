package com.jscreations.myloginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    EditText username, email,password;
    Button regbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        regbtn = findViewById(R.id.regbtn);


        mAuth = FirebaseAuth.getInstance();


        regbtn = findViewById(R.id.regbtn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();
            }
        });

        TextView textView = findViewById(R.id.logint);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    private void registerUser() {
        String uname = username.getText().toString();
        String eml = email.getText().toString();
        String pass = password.getText().toString();

        if (uname.isEmpty()){
            username.setError("Username is required");
            username.requestFocus();
            return;
        }

        if (eml.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if (pass.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()){
            email.setError("Please provide valid email");
            email.requestFocus();
            return;
        }

        if (pass.length()<6){
            password.setError("Min password length is 6 characters");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(eml,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Users user = new Users(uname,eml);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(RegisterActivity.this, "Failed, Try again", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(RegisterActivity.this, "Failed, Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void showMainActivity(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
        finish();

    }
}