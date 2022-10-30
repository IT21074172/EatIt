package com.jscreations.myloginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewLocation extends AppCompatActivity {

    Button addaddress, viewadd;
    EditText adname, addr;

    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_location);

        addaddress = findViewById(R.id.addbtn);
        viewadd =findViewById(R.id.viewAddress);
        adname = findViewById(R.id.adrsnameet);
        addr = findViewById(R.id.addresset);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        addaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        viewadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddNewLocation.this, AddressList.class));
                finish();
            }
        });
    }

    private void insertData(){
        String addname = adname.getText().toString();
        String add = addr.getText().toString();
        String id = databaseReference.push().getKey();

        Address address = new Address(addname, add);
        databaseReference.child("Address").child(id).setValue(address).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    Toast.makeText(AddNewLocation.this, "Data Added", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(AddNewLocation.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}