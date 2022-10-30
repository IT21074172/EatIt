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

public class AddItem extends AppCompatActivity {

    Button additem, viewitem;
    EditText name, price,decs;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        additem = findViewById(R.id.additemnew);
        viewitem =findViewById(R.id.viewitem);
        name = findViewById(R.id.itemet);
        price = findViewById(R.id.priceet);
        decs = findViewById(R.id.desctxt);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        viewitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddItem.this, Items.class));
                finish();
            }
        });
    }

    private void insertData(){
        String iname = name.getText().toString();
        String iprice = price.getText().toString();
        String idesc = decs.getText().toString();
        String id = databaseReference.push().getKey();

        Item item = new Item(iname, iprice,idesc);
        databaseReference.child("Items").child(id).setValue(item).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    Toast.makeText(AddItem.this, "Data Added", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(AddItem.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}