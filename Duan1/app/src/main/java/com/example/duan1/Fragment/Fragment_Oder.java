package com.example.duan1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Model.Product;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_Cart;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Oder extends Fragment {
    RecyclerView recyclerView;
    RecyclerView_Cart recyclerView_cart;
    RecyclerView_Cart getRecyclerView_cart;
    TextView giaTien;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_oder, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerView);
        List<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.cake,"Bánh kem 1", 12000, true));
        list.add(new Product(R.drawable.hamburge,"Hamburger 1", 12000));
        list.add(new Product(R.drawable.more,"More 1", 12000));
        list.add(new Product(R.drawable.ramen,"Ramen 1", 12000, true));
        list.add(new Product(R.drawable.rau,"Rau 1", 12000));
        list.add(new Product(R.drawable.more,"More 1", 12000));
        list.add(new Product(R.drawable.cake,"Bánh kem 1", 12000));
        list.add(new Product(R.drawable.rau,"Rau 1", 12000));
        list.add(new Product(R.drawable.more,"More 1", 12000));
        list.add(new Product(R.drawable.cake,"Bánh kem 1", 12000));

        Funcion_recyclerView_cart(list);
//        giaTien.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                recyclerView_cart.tinhtong()
//            }
//        });

    }

    private void Funcion_recyclerView_cart(List<Product> list){
        recyclerView_cart = new RecyclerView_Cart(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerView_cart);
    }

}
