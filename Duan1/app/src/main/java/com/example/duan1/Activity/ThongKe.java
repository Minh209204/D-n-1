package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.duan1.Database.Table_DonHang;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_ThongKe;
import com.example.duan1.RecyclerView.RecyclerView_XapXep;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThongKe extends AppCompatActivity {
    RecyclerView rcy_thongke;
    Toolbar toolbar_thongke;
    Button btn_tang, btn_giam;
//    RecyclerView_ThongKe recyclerViewThongKe;
    RecyclerView_XapXep recyclerViewXapXep;
    Table_DonHang table_donHang;
    Table_SanPham table_sanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        Model_SanPham model_sanPham = new Model_SanPham();

        table_sanPham = new Table_SanPham(this);
        table_donHang = new Table_DonHang(this);

        rcy_thongke = findViewById(R.id.rcy_thongke);
        btn_tang = findViewById(R.id.btn_tang);
        btn_giam = findViewById(R.id.btn_giam);
        toolbar_thongke = findViewById(R.id.toolbar_thongke);

        setSupportActionBar(toolbar_thongke);
        getSupportActionBar().setTitle("Thống kê");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Model_SanPham> listSP = table_sanPham.getAll();
        btn_tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(listSP, new Comparator<Model_SanPham>() {
                    @Override
                    public int compare(Model_SanPham o1, Model_SanPham o2) {
                        return Integer.compare(o2.getLuotMuaSP(), o1.getLuotMuaSP());
                    }
                });
                recyclerViewXapXep = new RecyclerView_XapXep(listSP, ThongKe.this);
                LinearLayoutManager layoutManager = new LinearLayoutManager(ThongKe.this, LinearLayoutManager.VERTICAL, false);
                rcy_thongke.setAdapter(recyclerViewXapXep);
                rcy_thongke.setLayoutManager(layoutManager);
            }
        });
        btn_giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(listSP, new Comparator<Model_SanPham>() {
                    @Override
                    public int compare(Model_SanPham o1, Model_SanPham o2) {
                        return Integer.compare(o1.getLuotMuaSP(), o2.getLuotMuaSP());
                    }
                });
                recyclerViewXapXep = new RecyclerView_XapXep(listSP, ThongKe.this);
                LinearLayoutManager layoutManager = new LinearLayoutManager(ThongKe.this, LinearLayoutManager.VERTICAL, false);
                rcy_thongke.setAdapter(recyclerViewXapXep);
                rcy_thongke.setLayoutManager(layoutManager);
            }
        });



















//        Model_DonHang model_donHang = new Model_DonHang();
//        model_donHang.setTrangThai("Đã xác nhận");
//
//        List<Model_DonHang> list = table_donHang.getThongKe(model_donHang);

//        recyclerViewThongKe = new RecyclerView_ThongKe(this, list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        rcy_thongke.setAdapter(recyclerViewThongKe);
//        rcy_thongke.setLayoutManager(layoutManager);

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}