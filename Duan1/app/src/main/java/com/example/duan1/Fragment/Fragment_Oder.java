package com.example.duan1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;

import com.example.duan1.RecyclerView.RecyclerView_Cart;


public class Fragment_Oder extends Fragment {
    RecyclerView recyclerView;
    RecyclerView_Cart recyclerView_cart;
    TextView giaTien;
    Model_SanPham pham;
    Table_SanPham table_sanPham;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_oder, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerView);
//        giaTien = view.findViewById(R.id.giaTien);
        table_sanPham = new Table_SanPham(getContext());

//        List<SanPham> list = table_sanPham.getAll();


//        List<SanPham> list = new ArrayList<>();
//        list.add(new SanPham(R.drawable.cake,"Bánh kem 1", 12000));
//        list.add(new SanPham(R.drawable.hamburge,"Hamburger 1", 12000));
//        list.add(new SanPham(R.drawable.more,"More 1", 12000));
//        list.add(new SanPham(R.drawable.ramen,"Ramen 1", 12000));
//        list.add(new SanPham(R.drawable.rau,"Rau 1", 12000));
//        list.add(new SanPham(R.drawable.more,"More 1", 12000));
//        list.add(new SanPham(R.drawable.cake,"Bánh kem 1", 12000));
//        list.add(new SanPham(R.drawable.rau,"Rau 1", 12000));
//        list.add(new SanPham(R.drawable.more,"More 1", 12000));
//        list.add(new SanPham(R.drawable.cake,"Bánh kem 1", 12000));

//        Funcion_recyclerView_cart(list);

    }

//    private void Funcion_recyclerView_cart(List<SanPham> list){
//        recyclerView_cart = new RecyclerView_Cart(getContext(), list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(recyclerView_cart);
//    }


}
