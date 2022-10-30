package com.jscreations.myloginapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class MakeOrder extends AppCompatActivity {

    RecyclerView recyclerView;
//    OrderAdapter orderAdapter;

    FirebaseFirestore fStore;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);




        fStore = FirebaseFirestore.getInstance();

//        DocumentReference documentReference = fStore.collection("Orders");

//        CollectionReference Order =  fStore.collection("Orders");
//
//        OrderModel orderModel = new OrderModel("SampleAddress2","Assigned to a Driver","SampleUser2","sameAsAbove");
//
//        Order.document("UserUI4").set(orderModel).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(MakeOrder.this, "Your details has been added ", Toast.LENGTH_SHORT).show();
//            }
//        });

//        Create data
//        CollectionReference UsersCollection =  fStore.collection("Users");
//
//        Users Users = new Users("sampleEmail","sampleUsername");
//
//        UsersCollection.document("userTest").set(Users).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(MakeOrder.this, "User details has been added ", Toast.LENGTH_SHORT).show();
//            }
//        });


//        Read data from fireStore
//                documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                        System.out.println("Data from thte data base "+ documentSnapshot.getString("Address"))
//                        System.out.println("Data from thte data base "+ documentSnapshot.getString("Status"));
//                        System.out.println("Data from thte data base "+ documentSnapshot);
//
//
//                    }
//
//
//                });


//        Read all the data in the firebase data collection

//        db.collection("Orders").addSnapshotListener(new EventListener<QuerySnapshot>() {
//
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                System.out.println("Data from the data base "+ value.getDocuments().get(0).getData());
//                System.out.println("Data from the data base "+ value.getDocuments().get(1).getData());
//
//                if(error != null){
//                    System.out.println("This is inside the error change");
//                    Log.e("Firebase Error",error.getMessage());
//                    return;
//                }
//                for (DocumentChange dc : value.getDocumentChanges()){
//                    System.out.println("This is inside the document change" + dc.getDocument().toObject(OrderModel.class).address);
//                    System.out.println(dc.getDocument().toObject(OrderModel.class));
//                }
//
//            }
//        });


//        System.out.println("Data from thte data base ");

//        //View Configuration for the recycler view
//        recyclerView = (RecyclerView) findViewById(R.id.rv);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        FirebaseRecyclerOptions<OrderModel> options =
//                new FirebaseRecyclerOptions.Builder<OrderModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Orders"), OrderModel.class)
//                        .build();
//
//
//        orderAdapter = new OrderAdapter(options);
//        recyclerView.setAdapter(orderAdapter);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        orderAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        orderAdapter.stopListening();
//
//
//
//    }
}