package com.example.duan1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.duan1.Database.Table_DonHang;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_ThongKe;

import java.util.List;

public class ThongKe extends AppCompatActivity {
    RecyclerView rcy_thongke;
    RecyclerView_ThongKe recyclerViewThongKe;
    Table_DonHang table_donHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        rcy_thongke = findViewById(R.id.rcy_thongke);
        table_donHang = new Table_DonHang(this);

        Model_DonHang model_donHang = new Model_DonHang();
        model_donHang.setTrangThai("Đã xác nhận");

        List<Model_DonHang> list = table_donHang.getThongKe(model_donHang);

        recyclerViewThongKe = new RecyclerView_ThongKe(this, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcy_thongke.setAdapter(recyclerViewThongKe);
        rcy_thongke.setLayoutManager(layoutManager);

    }
}