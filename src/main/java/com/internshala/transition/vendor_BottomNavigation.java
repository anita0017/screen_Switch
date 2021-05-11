package com.internshala.transition;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class vendor_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_bottom_navigation);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.dashboard:
                fragment=new Dashboard();
                break;
            case R.id.orders:
                fragment=new Orders();
                break;
            case R.id.addproducts:
                fragment=new AddProduct();
                break;
            case R.id.profile:
                fragment=new Profile();
                break;
        }
        return loadcheffragment(fragment);
    }
    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
            return true;
        }
        return false;
    }
}