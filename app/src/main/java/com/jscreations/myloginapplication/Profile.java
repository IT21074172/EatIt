package com.jscreations.myloginapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profile extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    CartFragment cartFragment = new CartFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigationView  = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,profileFragment).commit();

//        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.notification);
//        badgeDrawable.setVisible(true);
//        badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,homeFragment).commit();
                        return true;
                    case R.id.searchFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,searchFragment).commit();
                        return true;
                    case R.id.cartFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,cartFragment).commit();
                        return true;

                    case R.id.profileFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,profileFragment).commit();
                        return true;
                }

                return false;
            }
        });



    }
}