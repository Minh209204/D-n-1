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

public class RecyclerView_XapXep extends RecyclerView.Adapter<RecyclerView_XapXep.Holder_ThongKe>{
    List<Model_SanPham> list;
    Context context;

    public RecyclerView_XapXep(List<Model_SanPham> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder_ThongKe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.rcy_xapxep_sanpham, null);
        RecyclerView_XapXep.Holder_ThongKe holderThongKe = new Holder_ThongKe(view);

        return holderThongKe;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_ThongKe holder, int position) {
        Model_SanPham model_sanPham = list.get(position);

        Picasso.get().load(model_sanPham.getAnhSP()).into(holder.img_xapxep);
        holder.txt_thongke_name.setText(model_sanPham.getTenSP());
        holder.txt_thongke_price.setText(String.valueOf(model_sanPham.getGiaTienSP()));
        holder.txt_soluongban.setText(String.valueOf(model_sanPham.getLuotMuaSP()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_ThongKe extends RecyclerView.ViewHolder {
        TextView txt_thongke_name, txt_thongke_price, txt_soluongban;
        ImageView img_xapxep;
        public Holder_ThongKe(@NonNull View itemView) {
            super(itemView);
            txt_thongke_name = itemView.findViewById(R.id.txt_thongke_name);
            txt_thongke_price = itemView.findViewById(R.id.txt_thongke_price);
            txt_soluongban = itemView.findViewById(R.id.txt_soluongban);
            img_xapxep = itemView.findViewById(R.id.img_xapxep);
        }
    }
}
