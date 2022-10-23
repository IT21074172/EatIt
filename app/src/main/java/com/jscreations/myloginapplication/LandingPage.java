package com.jscreations.myloginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        configurLoginbtn();
        configurRegbtn();
    }

    private void configurLoginbtn(){
        Button loginbtnn = (Button) findViewById(R.id.loginbtnn);
        loginbtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this, MainActivity.class));

            }
        });
    }

    private void configurRegbtn(){
        Button regbtnn = (Button) findViewById(R.id.regbtnn);
        regbtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this, RegisterActivity.class));

            }
        });
    }
}