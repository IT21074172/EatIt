package com.jscreations.myloginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        ListView listView = findViewById(R.id.list);

        List<String> list = new ArrayList<>();
        list.add("Orders");
        list.add("Favourite");
        list.add("Wallet");
        list.add("Help");
        list.add("Promotion");
        list.add("Settings");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                }else if(position == 1){

                }else if(position == 2){

                }else if(position == 3){
                    startActivity(new Intent(ListMenu.this, Help.class));

                }else if(position == 4){
                    startActivity(new Intent(ListMenu.this, Promotions.class));

                }else if(position == 5){
                    startActivity(new Intent(ListMenu.this, Settings.class));
                }
            }
        });

    }
}