package com.example.duan1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;

public class Fragment_HomePage extends Fragment {
//    RecyclerView_Horizontal_Product recyclerView_horizontal_product;
//    RecyclerView_Vertical_Product recyclerView_vertical_product;///
    RecyclerView recyclerView_Horizontal, recyclerView_Vertical;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homepage, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView_Horizontal = view.findViewById(R.id.recyclerView_Horizontal);
        recyclerView_Vertical = view.findViewById(R.id.recyclerView_Vertical);

//        List<SanPham> list = new ArrayList<>();
//        list.add(new SanPham(R.drawable.cake,"Bánh kem 1", 12000));
//        list.add(new SanPham(R.drawable.hamburge,"Hamburger 1", 12000));
//        list.add(new SanPham(R.drawable.more,"More 1", 12000));
//        list.add(new SanPham(R.drawable.ramen,"Ramen 1", 12000));
//        list.add(new SanPham(R.drawable.rau,"Rau 1", 12000));
//        list.add(new SanPham(R.drawable.more,"More 1", 12000));
//        list.add(new SanPham(R.drawable.cake,"Bánh kem 1", 12000));
//        list.add(new SanPham(R.drawable.rau,"Rau 1", 12000));
//
//        funcion_recyclerView_horizontal(list);
//        funcion_recyclerView_vertical(list);
    }

//    private void funcion_recyclerView_horizontal(List<SanPham> list){
//        recyclerView_horizontal_product = new RecyclerView_Horizontal_Product(getContext(), list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
//
//        recyclerView_Horizontal.setLayoutManager(layoutManager);
//        recyclerView_Horizontal.setAdapter(recyclerView_horizontal_product);
//        recyclerView_horizontal_product.notifyDataSetChanged();
//    }
//
//    private void funcion_recyclerView_vertical(List<SanPham> list){
//        recyclerView_vertical_product = new RecyclerView_Vertical_Product(getContext(), list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//
//        recyclerView_Vertical.setLayoutManager(layoutManager);
//        recyclerView_Vertical.setAdapter(recyclerView_vertical_product);
//        recyclerView_vertical_product.notifyDataSetChanged();
//    }


}
