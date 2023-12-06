package com.example.duan1.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_DonHang;
import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;

import com.example.duan1.RecyclerView.RecyclerView_Oder_KhachHang;

import java.util.List;


public class Fragment_Oder_KhachHang extends Fragment {
    RecyclerView rcy_oder;
    Table_DonHang table_donHang;
    Table_KhachHang table_khachHang;
    RecyclerView_Oder_KhachHang recyclerView_oder_khachHang;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_oder_khachhang, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        table_khachHang = new Table_KhachHang(getContext());
        table_donHang = new Table_DonHang(getContext());
        Model_KhachHang model_khachHang = new Model_KhachHang();
        Model_DonHang model_donHang = new Model_DonHang();

        rcy_oder = view.findViewById(R.id.rcy_oder);

        //tim khach hang theo tai khoan mat khau khi dang nhap
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");
        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);
        List<Model_KhachHang> listMaKH = table_khachHang.checkKhachHang(model_khachHang);
        model_donHang.setMaKH(listMaKH.get(0).getMaKH());

        List<Model_DonHang> listDH = table_donHang.getHoaDonKhachHang(model_donHang);
        Log.d("TAG", "onViewCreated: " + model_donHang.getMaKH() + "");
        recyclerView_oder_khachHang = new RecyclerView_Oder_KhachHang(getContext(), listDH);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcy_oder.setAdapter(recyclerView_oder_khachHang);
        rcy_oder.setLayoutManager(layoutManager);

    }



}
