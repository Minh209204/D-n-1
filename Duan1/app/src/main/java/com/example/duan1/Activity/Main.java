package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.duan1.Fragment.Fragment_Cart;
import com.example.duan1.Fragment.Fragment_HomePage;
import com.example.duan1.Fragment.Fragment_Oder;
import com.example.duan1.Fragment.Fragment_ThongBao;
import com.example.duan1.Fragment.Fragment_ThongTin_Admin;
import com.example.duan1.Fragment.Fragment_ThongTin_KhacHang;
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
    Fragment_ThongTin_Admin fragment_thongTin_admin;
    Fragment_ThongTin_KhacHang fragment_thongTin_khacHang;
    Fragment_Cart fragment_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_homePage = new Fragment_HomePage();
        fragment_oder = new Fragment_Oder();
        fragment_thongBao = new Fragment_ThongBao();
        fragment_thongTin_admin = new Fragment_ThongTin_Admin();
        fragment_thongTin_khacHang = new Fragment_ThongTin_KhacHang();
        fragment_cart = new Fragment_Cart();

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.frameLayout, fragment_homePage).commit();

        Intent intent = getIntent();
        String taikhoan = intent.getStringExtra("taikhoan");
        String matkhau = intent.getStringExtra("matkhau");

        Log.d("TAG", "onCreate: " + taikhoan + matkhau);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.HomePage){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_homePage).commit();
                }else if (item.getItemId() == R.id.Cart){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_cart).commit();
                }else if (item.getItemId() == R.id.Oder){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_oder).commit();
                }else if(item.getItemId() == R.id.Notification){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_thongBao).commit();
                } else if (taikhoan == "admin" && matkhau == "123" && item.getItemId() == R.id.Account) {
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_thongTin_admin).commit();
                } else if (taikhoan != "admin" && matkhau != "123" && item.getItemId() == R.id.Account) {
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_thongTin_admin).commit();
                }
                return true;
            }
        });



    }
}