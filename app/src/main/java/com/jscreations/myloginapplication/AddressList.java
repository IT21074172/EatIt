package com.jscreations.myloginapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddressList extends AppCompatActivity implements RecycleViewInterface{

    RecyclerView recyclerView1;
    ArrayList<Address> list;
    DatabaseReference databaseReference;
    MyAdapter2 adapter;
    ArrayList<AddressID> list2;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AddressList.this,AddNewLocation.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);

        recyclerView1 =findViewById(R.id.recyclview1);
        databaseReference= FirebaseDatabase.getInstance().getReference("Address");
        list = new ArrayList<>();
        list2 =new ArrayList<AddressID>();
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter2(this,list,this);
        recyclerView1.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Address address = dataSnapshot.getValue(Address.class);
//                    System.out.println("gfgfg"+dataSnapshot.getKey());
                    AddressID a1 = new AddressID(dataSnapshot.getKey());
                    list2.add(a1);
                    list.add(address);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(AddressList.this, updataAddress.class);

        intent.putExtra("AddressName",list.get(position).getAddressname());
        intent.putExtra("Address",list.get(position).getAddresstext());
        intent.putExtra("id",list2.get(position).getId());

        startActivity(intent);


    }
}