package com.jscreations.myloginapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Locale;

public class ViewAllOrders extends AppCompatActivity implements OrderInterface {

    RecyclerView recyclerView;
    ArrayList<OrderModel> orderModelArrayList;
    OrderDataAdapter myAdapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    ArrayList<OrderIdClass> orderIdClasses;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data from the database...");
        progressDialog.show();
        setContentView(R.layout.activity_view_all_orders);


//        recyclerView = findViewById(R.id.OrderListView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        orderModelArrayList = new ArrayList<OrderModel>();
        orderIdClasses = new ArrayList<OrderIdClass>();
        myAdapter = new OrderDataAdapter(ViewAllOrders.this,orderModelArrayList,this);


        recyclerView.setAdapter(myAdapter);

        EventChangeListner();

    }
    private void EventChangeListner() {
        db.collection("Orders")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error != null){
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            Log.e("Firebase Error",error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()){
                            if(dc.getType()== DocumentChange.Type.ADDED){
                                System.out.println(dc.getDocument().getId());
                                OrderIdClass c = new OrderIdClass((dc.getDocument().getId()));
                                orderIdClasses.add(c);
                                orderModelArrayList.add((dc.getDocument()).toObject(OrderModel.class));
                            }
                            progressDialog.dismiss();
                            myAdapter.notifyDataSetChanged();
                        }

                    }
                });
    }

    @Override
    public void onItemClick(int position) {

        Intent updateIntent = new Intent(ViewAllOrders.this,updataOrder.class);

        updateIntent.putExtra("orderName",orderModelArrayList.get(position).getOrderName());
        updateIntent.putExtra("riderName",orderModelArrayList.get(position).getRiderName());
        updateIntent.putExtra("specialIns",orderModelArrayList.get(position).getSpecialInstructions());
        updateIntent.putExtra("id",orderIdClasses.get(position).getId());

        startActivity(updateIntent);

    }
}