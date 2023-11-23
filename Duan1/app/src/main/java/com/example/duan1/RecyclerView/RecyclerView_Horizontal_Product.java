package com.example.duan1.RecyclerView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;

import java.util.List;

public class RecyclerView_Horizontal_Product extends RecyclerView.Adapter<RecyclerView_Horizontal_Product.Holder_Horizontal> {

    private Context context;
    private List<Model_SanPham> list;
    Model_SanPham sanPham;

    public RecyclerView_Horizontal_Product(Context context, List<Model_SanPham> list) {
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
        sanPham = list.get(position);

//        holder.img_Horizontal.setImageResource(sanPham.getImg());
//        holder.txt_Hozizontal_name.setText(sanPham.getTenSp());
//        holder.txt_Hozizontal_price.setText(sanPham.getGiaTien() + "");
//        holder.layout_product.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, QLSanPham.class));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Holder_Horizontal extends RecyclerView.ViewHolder {
        ImageView img_Horizontal;
        TextView txt_Hozizontal_name, txt_Hozizontal_price;
        LinearLayout layout_product;

        public Holder_Horizontal(@NonNull View itemView) {
            super(itemView);
            img_Horizontal = itemView.findViewById(R.id.img_Horizontal);
            txt_Hozizontal_name = itemView.findViewById(R.id.txt_Hozizontal_name);
            txt_Hozizontal_price = itemView.findViewById(R.id.txt_Hozizontal_price);
            layout_product = itemView.findViewById(R.id.layout_product);
        }
    }

}
