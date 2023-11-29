package com.example.duan1.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerView_Theloai extends RecyclerView.Adapter<RecyclerView_Theloai.Holder_Theloai>{
    Context context;
    List<Model_SanPham> list;

    public RecyclerView_Theloai(Context context, List<Model_SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_Theloai onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.rcy_theloai_product, null);
        RecyclerView_Theloai.Holder_Theloai holder_theloai = new Holder_Theloai(v);
        return holder_theloai;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Theloai holder, int position) {
        Model_SanPham model_sanPham =list.get(position);

        Picasso.get().load(model_sanPham.getAnhSP()).into(holder.img_TheLoai);
        holder.txt_TheLoai_name.setText(model_sanPham.getTenSP());
        holder.txt_TheLoai_price.setText(model_sanPham.getGiaTienSP() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_Theloai extends RecyclerView.ViewHolder {
        ImageView img_TheLoai;
        TextView txt_TheLoai_name, txt_TheLoai_price;
        public Holder_Theloai(@NonNull View itemView) {
            super(itemView);

            img_TheLoai = itemView.findViewById(R.id.img_TheLoai);
            txt_TheLoai_name = itemView.findViewById(R.id.txt_TheLoai_name);
            txt_TheLoai_price = itemView.findViewById(R.id.txt_TheLoai_price);

        }
    }
}
