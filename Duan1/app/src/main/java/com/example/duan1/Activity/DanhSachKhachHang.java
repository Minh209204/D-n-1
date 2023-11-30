package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_DSKhachHang;

import java.util.List;

public class DanhSachKhachHang extends AppCompatActivity {

    Toolbar toolbar_khachhang;
    RecyclerView rcy_qlkhachhang;
    RecyclerView_DSKhachHang recyclerView_dsKhachHang;
    Table_KhachHang table_taiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_khach_hang);

        toolbar_khachhang = findViewById(R.id.toolbar_khachhang);
        rcy_qlkhachhang = findViewById(R.id.rcy_qlkhachhang);
        table_taiKhoan = new Table_KhachHang(DanhSachKhachHang.this);

        setSupportActionBar(toolbar_khachhang);
        getSupportActionBar().setTitle("Danh sách khách hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Model_KhachHang> list = table_taiKhoan.getAll();

        recyclerView_dsKhachHang = new RecyclerView_DSKhachHang(DanhSachKhachHang.this, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(DanhSachKhachHang.this, LinearLayoutManager.VERTICAL, false);
        rcy_qlkhachhang.setLayoutManager(layoutManager);
        rcy_qlkhachhang.setAdapter(recyclerView_dsKhachHang);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}