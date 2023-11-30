package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_Theloai;

import java.util.List;

public class TheLoaiSanPham extends AppCompatActivity {
    RecyclerView rcy_theloai;
    RecyclerView_Theloai recyclerView_theloai;
    Model_SanPham model_sanPham;
    Table_SanPham table_sanPham;
    List<Model_SanPham> list;
    Toolbar toolbar_theloai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai_san_pham);

        rcy_theloai = findViewById(R.id.rcy_theloai);
        toolbar_theloai = findViewById(R.id.toolbar_theloai);
        table_sanPham = new Table_SanPham(TheLoaiSanPham.this);
        model_sanPham = new Model_SanPham();

        setSupportActionBar(toolbar_theloai);
        getSupportActionBar().setTitle("Danh sách sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int MaTL = intent.getIntExtra("matl", -1);

        model_sanPham.setMaTL(MaTL);
        list = table_sanPham.getTheLoai(model_sanPham);
        recyclerView_theloai = new RecyclerView_Theloai(TheLoaiSanPham.this, list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(TheLoaiSanPham.this, LinearLayoutManager.VERTICAL, false);
        rcy_theloai.setLayoutManager(layoutManager);
        rcy_theloai.setAdapter(recyclerView_theloai);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}