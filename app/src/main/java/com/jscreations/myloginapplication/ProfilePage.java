package com.jscreations.myloginapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilePage extends AppCompatActivity {

    TextView name;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        name = findViewById(R.id.usernamev);

        Cursor cursor = DB.getNameData();
        if (cursor.getCount() == 0) {
            Toast.makeText(ProfilePage.this, "No data generate", Toast.LENGTH_SHORT).show();
            return;
        }

        if (cursor.moveToFirst()) {
            do {
                String username = cursor.getString(1);
                name.setText(username);
            } while (cursor.moveToNext());
        }
    }
}