package com.jscreations.myloginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OrderManagement extends AppCompatActivity {

    Button btnVIewAllOrders;
    Button btnAssignAnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_management);

        btnVIewAllOrders = findViewById(R.id.btnViewAllOrders);
        btnAssignAnOrder = findViewById(R.id.btnAssignOrders);

        
        btnVIewAllOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(OrderManagement.this,"View All Orders",Toast.LENGTH_SHORT).show();

                Intent viewAllOrders = new Intent(OrderManagement.this,ViewAllOrders.class);
                startActivity(viewAllOrders);
            }
        });

        btnAssignAnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent makeNewOrder = new Intent(OrderManagement.this,CreateNewOrder.class);
                startActivity(makeNewOrder);
//                Toast.makeText(OrderManagement.this,"Assign Orders to Riders",Toast.LENGTH_SHORT).show();
            }
        });


    }

}