package com.jscreations.myloginapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Insertdata extends AppCompatActivity {

    EditText etname, age;
    Button btninsertdata;

    DatabaseReference studentDbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertdata);

        etname = findViewById(R.id.etName);
        age = findViewById(R.id.age);
        btninsertdata = findViewById(R.id.btninsert);

        studentDbRef = FirebaseDatabase.getInstance().getReference().child("Test");

        btninsertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void insertData(){
        String name = etname.getText().toString();
        String ag = age.getText().toString();

        Test test = new Test(name, ag);
        studentDbRef.push().setValue(test);
        Toast.makeText(Insertdata.this, "Data Added", Toast.LENGTH_SHORT).show();
    }
}