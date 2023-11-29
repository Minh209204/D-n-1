package com.example.duan1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Activity.TheLoaiSanPham;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_Horizontal_Product;
import com.example.duan1.RecyclerView.RecyclerView_Vertical_Product;

import java.util.Collections;
import java.util.List;

public class Fragment_HomePage extends Fragment {
    RecyclerView_Horizontal_Product recyclerView_horizontal_product;
    RecyclerView_Vertical_Product recyclerView_vertical_product;
    RecyclerView recyclerView_Horizontal, recyclerView_Vertical;
    Table_SanPham table_sanPham;
    List<Model_SanPham> list;
    ImageView Hamburger, Pizza, Noodles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homepage, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        table_sanPham = new Table_SanPham(getContext());

        recyclerView_Horizontal = view.findViewById(R.id.recyclerView_Horizontal);
        recyclerView_Vertical = view.findViewById(R.id.recyclerView_Vertical);
        Hamburger = view.findViewById(R.id.Hamburger);
        Pizza = view.findViewById(R.id.Pizza);
        Noodles = view.findViewById(R.id.Noodles);

        list = table_sanPham.getAll();
        Collections.shuffle(list);
        funcion_recyclerView_horizontal(list);
        funcion_recyclerView_vertical(list);

        Hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TheLoaiSanPham.class);
                intent.putExtra("matl", 1);
                startActivity(intent);
            }
        });

        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TheLoaiSanPham.class);
                intent.putExtra("matl", 2);
                startActivity(intent);
            }
        });

        Noodles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TheLoaiSanPham.class);
                intent.putExtra("matl", 3);
                startActivity(intent);
            }
        });
    }

    private void funcion_recyclerView_horizontal(List<Model_SanPham> list){
        recyclerView_horizontal_product = new RecyclerView_Horizontal_Product(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        recyclerView_Horizontal.setLayoutManager(layoutManager);
        recyclerView_Horizontal.setAdapter(recyclerView_horizontal_product);
        recyclerView_horizontal_product.notifyDataSetChanged();

    }

    private void funcion_recyclerView_vertical(List<Model_SanPham> list){
        recyclerView_vertical_product = new RecyclerView_Vertical_Product(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        recyclerView_Vertical.setLayoutManager(layoutManager);
        recyclerView_Vertical.setAdapter(recyclerView_vertical_product);
        recyclerView_vertical_product.notifyDataSetChanged();
    }


}
