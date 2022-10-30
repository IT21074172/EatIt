package com.jscreations.myloginapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class updataOrder extends AppCompatActivity {

    Button updateBtn;
    Button deletebtn;

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_order);

        updateBtn = findViewById(R.id.btnUpdate);
        deletebtn = findViewById(R.id.btnDelete);

        String orderName = getIntent().getStringExtra("orderName");
        String riderName = getIntent().getStringExtra("riderName");
        String specialIns = getIntent().getStringExtra("specialIns");
        String ID = getIntent().getStringExtra("id");

        EditText order = findViewById(R.id.updateOrderName);
        EditText rider = findViewById(R.id.updateRiderName);
        EditText specialI = findViewById(R.id.updateSpecialIns);

        order.setText(orderName);
        rider.setText(riderName);
        specialI.setText(specialIns);

        System.out.println("ID is "+ID);

//        Toast.makeText(updataOrder.this,ID,Toast.LENGTH_SHORT).show();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText orderNameupdate = findViewById(R.id.updateOrderName);
                EditText riderNameupdate = findViewById(R.id.updateRiderName);
                EditText specialInsupdate = findViewById(R.id.updateSpecialIns);
                if(orderNameupdate.getText().toString().length() < 1 || riderNameupdate.getText().toString().length() < 1 || specialInsupdate.getText().toString().length() < 1){
                    Toast.makeText(updataOrder.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    updateFireStore(ID,orderNameupdate.getText().toString(),riderNameupdate.getText().toString(),specialInsupdate.getText().toString());
                }

            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFireStoreData(ID);
            }
        });
    }

    public void updateFireStore(String id, String orderName,String riderName,String specialIns){
        db.collection("Orders").document(id).update("orderName",orderName,"riderName",riderName,"specialInstructions",specialIns).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(updataOrder.this, "Data Updated", Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(updataOrder.this,OrderManagement.class);
                startActivity(mainIntent);
//                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(updataOrder.this, "Data cannot Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void deleteFireStoreData(String id){
        db.collection("Orders").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(updataOrder.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(updataOrder.this,OrderManagement.class);
                startActivity(mainIntent);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(updataOrder.this, "Data cannot Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}