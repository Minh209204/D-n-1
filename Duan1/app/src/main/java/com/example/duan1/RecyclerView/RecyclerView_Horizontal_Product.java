package com.example.duan1.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Activity.Main;
import com.example.duan1.Model.Product;
import com.example.duan1.R;

import java.util.List;

public class RecyclerView_Horizontal_Product extends RecyclerView.Adapter<RecyclerView_Horizontal_Product.Holder_Horizontal> {

    private Context context;
    private List<Product> list;
    Product product;

    public RecyclerView_Horizontal_Product(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_Horizontal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.layout_horizontal_product, null);

        RecyclerView_Horizontal_Product.Holder_Horizontal holder = new Holder_Horizontal(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Horizontal holder, int position) {
        product = list.get(position);

        holder.img_Horizontal.setImageResource(product.getImg());
        holder.txt_Hozizontal_name.setText(product.getName());
        holder.txt_Hozizontal_price.setText(product.getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Holder_Horizontal extends RecyclerView.ViewHolder {
        ImageView img_Horizontal;
        TextView txt_Hozizontal_name, txt_Hozizontal_price;

        public Holder_Horizontal(@NonNull View itemView) {
            super(itemView);
            img_Horizontal = itemView.findViewById(R.id.img_Horizontal);
            txt_Hozizontal_name = itemView.findViewById(R.id.txt_Hozizontal_name);
            txt_Hozizontal_price = itemView.findViewById(R.id.txt_Hozizontal_price);
        }
    }

}
