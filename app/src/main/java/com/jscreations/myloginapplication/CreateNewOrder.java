package com.jscreations.myloginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateNewOrder extends AppCompatActivity {

    Button savebtn;

    FirebaseFirestore fstore = FirebaseFirestore.getInstance();

    CollectionReference OrderCollection =  fstore.collection("Orders");
//
//    Users Users = new Users("sampleEmail","sampleUsername");
//
//        UsersCollection.document("userTest").set(Users).addOnSuccessListener(new OnSuccessListener<Void>() {
//        @Override
//        public void onSuccess(Void unused) {
//            Toast.makeText(MakeOrder.this, "User details has been added ", Toast.LENGTH_SHORT).show();
//        }
//    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_order);
        savebtn = findViewById(R.id.btnsaveDetails);

        EditText order = findViewById(R.id.txtOrderNamefrm);
        EditText drive = findViewById(R.id.txtRiderNamefrm);
        EditText specialIns = findViewById(R.id.txtSpecialfrm);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(order.getText().toString().length() < 1 || drive.getText().toString().length() < 1 || specialIns.getText().toString().length() < 1){
                    Toast.makeText(CreateNewOrder.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    OrderModel om = new OrderModel(order.getText().toString(),drive.getText().toString(),specialIns.getText().toString());
                    OrderCollection.add(om).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(CreateNewOrder.this, "Order details added ", Toast.LENGTH_SHORT).show();

                        }
                    });
                }



//                OrderCollection.document("NewModel").set(om).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(CreateNewOrder.this, "Order details added ", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });
    }
}