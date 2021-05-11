package com.internshala.transition;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        View navigationView = findViewById(R.id.bottomNavigationView);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
        private BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                        Fragment selectedFragment = null;
                        switch(item.getItemId()){
                            case R.id.dashboard:
                                selectedFragment= new Dashboard();
                                break;
                            case R.id.orders:
                                selectedFragment= new Orders();
                                break;
                            case R.id.addproducts:
                                selectedFragment= new AddProduct();
                                break;
                            case R.id.profile:
                                selectedFragment= new Profile();
                                break;}
                  getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedFragment).commit();
                        return true;
                 }
    };
}