package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.duan1.Fragment.Fragment_HomePage;
import com.example.duan1.Fragment.Fragment_Oder;
import com.example.duan1.Fragment.Fragment_ThongBao;
import com.example.duan1.Fragment.Fragment_ThongTin;
import com.example.duan1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Main extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fm;
    Fragment_HomePage fragment_homePage;
    Fragment_Oder fragment_oder;
    Fragment_ThongBao fragment_thongBao;
    Fragment_ThongTin fragment_thongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_homePage = new Fragment_HomePage();
        fragment_oder = new Fragment_Oder();
        fragment_thongBao = new Fragment_ThongBao();
        fragment_thongTin = new Fragment_ThongTin();

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.frameLayout, fragment_homePage).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.HomePage){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_homePage).commit();
                }else if (item.getItemId() == R.id.Oder){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_oder).commit();
                }else if(item.getItemId() == R.id.Notification){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_thongBao).commit();
                }else if(item.getItemId() == R.id.Account){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_thongTin).commit();
                }

                return true;
            }
        });



    }
}