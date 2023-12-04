package com.example.duan1.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Oder_Product extends RecyclerView.Adapter<RecyclerView_Oder_Product.Holder_Oder_Product>{
    Context context;
    List<Model_DonHang> listDH;

    public RecyclerView_Oder_Product(Context context, List<Model_DonHang> listDH) {
        this.context = context;
        this.listDH = listDH;
    }

    @NonNull
    @Override
    public Holder_Oder_Product onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcy_oder_product, null);
        RecyclerView_Oder_Product.Holder_Oder_Product holderOderProduct = new Holder_Oder_Product(v);

        return holderOderProduct;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Oder_Product holder, int position) {
        Model_DonHang model_donHang = listDH.get(position);

        Picasso.get().load(model_donHang.getAnhSP()).into(holder.img_oder_product);
        holder.txt_oder_tensp.setText(model_donHang.getTenSP());
        holder.txt_oder_giasp.setText(model_donHang.getGiaSP() + "");
        holder.txt_oder_soluongsp.setText(model_donHang.getSoLuongSP() + "");


    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }

    public class Holder_Oder_Product extends RecyclerView.ViewHolder {
        ImageView img_oder_product;
        TextView txt_oder_tensp, txt_oder_giasp, txt_oder_soluongsp;
        public Holder_Oder_Product(@NonNull View itemView) {
            super(itemView);
            img_oder_product = itemView.findViewById(R.id.img_oder_product);
            txt_oder_tensp = itemView.findViewById(R.id.txt_oder_tensp);
            txt_oder_giasp = itemView.findViewById(R.id.txt_oder_giasp);
            txt_oder_soluongsp = itemView.findViewById(R.id.txt_oder_soluongsp);
        }
    }
}
