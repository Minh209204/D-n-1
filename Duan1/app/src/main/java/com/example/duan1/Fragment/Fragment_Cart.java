package com.example.duan1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_GioHang;
import com.example.duan1.Database.Table_HoaDon;
import com.example.duan1.Model.Model_GioHang;
import com.example.duan1.Model.Model_HoaDon;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_Cart;

import java.util.List;

public class Fragment_Cart extends Fragment {
    Table_GioHang table_hoaDon;
    List<Model_GioHang> list;
    RecyclerView_Cart recyclerView_cart;
    RecyclerView recyclerView;
    TextView txt_tongTien;
    Toolbar toolbar;
    int tong;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        txt_tongTien = view.findViewById(R.id.txt_tongTien);
        toolbar = view.findViewById(R.id.toolbar_cart);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Giỏ hàng");

        table_hoaDon = new Table_GioHang(getContext());
        list = table_hoaDon.getAll();
        recyclerView_cart = new RecyclerView_Cart(getContext(), list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(recyclerView_cart);
        recyclerView.setLayoutManager(layoutManager);

        Model_GioHang model_gioHang = new Model_GioHang();
        model_gioHang.setCheckBox(1);

        int tong = 0;
        list = table_hoaDon.getSanPham(model_gioHang);
        for (int i=0; i<list.size(); i++){
            tong+= list.get(i).getGiaSP();
        }
        txt_tongTien.setText(tong +"");

        txt_tongTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tong = 0;
                list = table_hoaDon.getSanPham(model_gioHang);
                for (int i=0; i<list.size(); i++){
                    tong+= list.get(i).getGiaSP();
                }
                Toast.makeText(activity, tong + "", Toast.LENGTH_SHORT).show();
                txt_tongTien.setText(tong +"");
            }
        });

    }





}
