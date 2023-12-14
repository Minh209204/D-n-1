package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Fragment.Fragment_Cart;
import com.example.duan1.Fragment.Fragment_HomePage;
import com.example.duan1.Fragment.Fragment_Oder_Admin;
import com.example.duan1.Fragment.Fragment_Oder_KhachHang;
import com.example.duan1.Fragment.Fragment_ThongTin_Admin;
//import com.example.duan1.Fragment.Fragment_ThongTin_KhacHang;
import com.example.duan1.Fragment.Fragment_ThongTin_KhacHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Main extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fm;
    Fragment_HomePage fragment_homePage;
    Fragment_Oder_KhachHang fragment_oder_khachHang;
    Fragment_ThongTin_Admin fragment_thongTin_admin;
    Fragment_ThongTin_KhacHang fragment_thongTin_khacHang;
    Fragment_Oder_Admin fragment_oder_admin;
    Fragment_Cart fragment_cart;
    Table_KhachHang table_khachHang;
    Model_KhachHang model_khachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table_khachHang = new Table_KhachHang(this);
        model_khachHang = new Model_KhachHang();

        fragment_homePage = new Fragment_HomePage();
        fragment_oder_khachHang = new Fragment_Oder_KhachHang();
        fragment_thongTin_admin = new Fragment_ThongTin_Admin();
        fragment_thongTin_khacHang = new Fragment_ThongTin_KhacHang();
        fragment_oder_admin = new Fragment_Oder_Admin();
        fragment_cart = new Fragment_Cart();

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.frameLayout, fragment_homePage).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                SharedPreferences sharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE);

                String taikhoan = sharedPreferences.getString("taikhoan", "");
                String matkhau =sharedPreferences.getString("matkhau", "");

                if (item.getItemId() == R.id.HomePage){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_homePage).commit();
                }else if (item.getItemId() == R.id.Cart){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_cart).commit();
                }else if (taikhoan.equals("admin") && matkhau.equals("123") && item.getItemId() == R.id.Oder){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_oder_admin).commit();
                }else if (taikhoan.toString() != "admin" && matkhau.toString() != "123" && item.getItemId() == R.id.Oder){
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_oder_khachHang).commit();
                }else if (taikhoan.equals("admin") && matkhau.equals("123") && item.getItemId() == R.id.Account) {
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_thongTin_admin).commit();
                }else if (taikhoan.toString() != "admin" && matkhau.toString() != "123" && item.getItemId() == R.id.Account) {
                    fm.beginTransaction().replace(R.id.frameLayout, fragment_thongTin_khacHang).commit();
                }
                return true;
            }
        });


    }
}

