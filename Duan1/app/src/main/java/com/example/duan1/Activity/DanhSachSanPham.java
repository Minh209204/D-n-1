package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_DSSanpham;

import java.util.List;

public class DanhSachSanPham extends AppCompatActivity {
    Toolbar toolbar_sanpham;
    RecyclerView rcy_qlsanpham;
    ImageButton btn_add_product;
    Table_SanPham table_sanPham;
    RecyclerView_DSSanpham recyclerView_dsSanpham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachsanpham);

        table_sanPham = new Table_SanPham(DanhSachSanPham.this);
        List<Model_SanPham> list = table_sanPham.getAll();
        recyclerView_dsSanpham = new RecyclerView_DSSanpham(DanhSachSanPham.this, list);

        toolbar_sanpham = findViewById(R.id.toolbar_sanpham);
        rcy_qlsanpham = findViewById(R.id.rcy_qlsanpham);
        btn_add_product = findViewById(R.id.btn_add_product);

        setSupportActionBar(toolbar_sanpham);
        getSupportActionBar().setTitle("Danh sách sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(DanhSachSanPham.this, RecyclerView.VERTICAL, false);
        rcy_qlsanpham.setLayoutManager(layoutManager);
        rcy_qlsanpham.setAdapter(recyclerView_dsSanpham);

        btn_add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DanhSachSanPham.this, Create_Product.class));
            }
        });

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