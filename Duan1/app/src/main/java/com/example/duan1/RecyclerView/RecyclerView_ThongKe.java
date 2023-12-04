package com.example.duan1.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_DonHang;
import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;

import java.util.List;

public class RecyclerView_ThongKe extends RecyclerView.Adapter<RecyclerView_ThongKe.Holder_ThongKe>{
    Context context;
    List<Model_DonHang> listDH;
    Table_DonHang table_donHang;
    Table_KhachHang table_khachHang;
    Table_SanPham table_sanPham;
    RecyclerView_Oder_Product recyclerView_oder_product;

    public RecyclerView_ThongKe(Context context, List<Model_DonHang> listDH) {
        this.context = context;
        this.listDH = listDH;
    }

    @NonNull
    @Override
    public Holder_ThongKe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcy_thongke, null);
        RecyclerView_ThongKe.Holder_ThongKe holderOder = new RecyclerView_ThongKe.Holder_ThongKe(v);

        return holderOder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_ThongKe holder, int position) {
        table_donHang = new Table_DonHang(context);
        table_khachHang = new Table_KhachHang(context);
        table_sanPham = new Table_SanPham(context);

        Model_DonHang model_donHang = listDH.get(position);

        holder.txt_oder_name.setText(model_donHang.getTenKH());
        holder.txt_oder_sdt.setText(model_donHang.getSDT() + "");
        holder.txt_oder_diachi.setText(model_donHang.getDiaChiKH());
        holder.txt_oder_tongtien.setText(model_donHang.getTongTien() + "");

        Model_DonHang model_donHang1 = new Model_DonHang();
        model_donHang1.setTrangThai("Đã xác nhận");

        List<Model_DonHang> list = table_donHang.getThongKe(model_donHang1);
        Toast.makeText(context, list.size() + "", Toast.LENGTH_SHORT).show();
        recyclerView_oder_product = new RecyclerView_Oder_Product(context, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rcy_oder.setLayoutManager(layoutManager);
        holder.rcy_oder.setAdapter(recyclerView_oder_product);
    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }

    public class Holder_ThongKe extends RecyclerView.ViewHolder {
        TextView txt_oder_madh, txt_oder_trangthai, txt_oder_name, txt_oder_sdt, txt_oder_diachi, txt_oder_tongtien;
        RecyclerView rcy_oder;
        public Holder_ThongKe(@NonNull View itemView) {
            super(itemView);
            txt_oder_name = itemView.findViewById(R.id.txt_oder_name);
            txt_oder_sdt = itemView.findViewById(R.id.txt_oder_sdt);
            txt_oder_diachi = itemView.findViewById(R.id.txt_oder_diachi);
            txt_oder_tongtien = itemView.findViewById(R.id.txt_oder_tongtien);
            rcy_oder = itemView.findViewById(R.id.rcy_oder);
        }
    }
}
