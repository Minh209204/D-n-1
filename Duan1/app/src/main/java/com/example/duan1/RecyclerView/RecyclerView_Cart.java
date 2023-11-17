package com.example.duan1.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Fragment.Fragment_Oder;
import com.example.duan1.Model.Product;
import com.example.duan1.R;

import java.util.List;

public class RecyclerView_Cart extends RecyclerView.Adapter<RecyclerView_Cart.Holder_Cart>{
    private Context context;
    private List<Product> list;
    Product product;
    int tong = 0, quantity = 1;

    public RecyclerView_Cart(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_Cart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.layout_giohang_product, null);

        RecyclerView_Cart.Holder_Cart holder_cart = new Holder_Cart(v);
        return holder_cart;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Cart holder, int position) {
        product = list.get(position);

        holder.img_cart.setImageResource(product.getImg());
        holder.txt_cart_name.setText(product.getName());
        holder.txt_cart_price.setText(String.valueOf(product.getPrice()));
        if (product.isCheckBox() == true){
            holder.cbox_cart.setChecked(true);
            tong += product.getPrice();
            Toast.makeText(context, String.valueOf(tong), Toast.LENGTH_SHORT).show();
        }else{
            holder.cbox_cart.setChecked(false);
        }

        tinhTien(holder);


        holder.btn_total_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.txt_quantity_cart.setText(++quantity + "");
            }
        });

        holder.btn_reduce_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity >= 0){
                    quantity-= 1;
                    tong -= product.getPrice();
                    holder.txt_quantity_cart.setText(--quantity + "");
                } else if (quantity <= 0) {
                    quantity = 0;
                    holder.txt_quantity_cart.setText(quantity + "");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_Cart extends RecyclerView.ViewHolder {
        CheckBox cbox_cart;
        ImageView img_cart;
        TextView txt_cart_name, txt_cart_price, txt_quantity_cart;
        ImageButton btn_total_cart, btn_reduce_cart, btn_delete_cart;


        public Holder_Cart(@NonNull View itemView) {
            super(itemView);
            cbox_cart = itemView.findViewById(R.id.cbox_cart);
            img_cart = itemView.findViewById(R.id.img_cart);
            txt_cart_name = itemView.findViewById(R.id.txt_cart_name);
            txt_cart_price = itemView.findViewById(R.id.txt_cart_price);
            txt_quantity_cart = itemView.findViewById(R.id.txt_quantity_cart);
            btn_total_cart = itemView.findViewById(R.id.btn_total_cart);
            btn_reduce_cart = itemView.findViewById(R.id.btn_reduce_cart);
            btn_delete_cart = itemView.findViewById(R.id.btn_delete_cart);
        }
    }

    public int tinhTien(Holder_Cart holder){
        holder.cbox_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.cbox_cart.isChecked() == true){
                    tong += product.getPrice();
                    Toast.makeText(context, String.valueOf(tong), Toast.LENGTH_SHORT).show();
                } else if (holder.cbox_cart.isChecked() == false) {
                    tong -= product.getPrice();
                    Toast.makeText(context, String.valueOf(tong), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return tong;
    }
}
