package com.amirulhidayah.sqlliteregistrasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class fragment extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        loadFragment(new menu1());
        BottomNavigationView navigation = findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.fragment1:
                fragment = new menu1();
                break;
            case R.id.fragment2:
                fragment = new menu2();
                break;
            case R.id.fragment3:
                fragment = new menu3();
                break;
        }
        return loadFragment(fragment);
    }

    public boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.menu_content,fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
