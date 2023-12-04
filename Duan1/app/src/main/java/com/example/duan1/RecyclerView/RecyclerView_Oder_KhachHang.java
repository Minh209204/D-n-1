package com.example.duan1.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_DonHang;
import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Oder_KhachHang extends RecyclerView.Adapter<RecyclerView_Oder_KhachHang.Holder_Oder_KhachHang>{
    Context context;
    List<Model_DonHang> listDH;
    Table_DonHang table_donHang;
    Table_KhachHang table_khachHang;
    Table_SanPham table_sanPham;
    RecyclerView_Oder_Product recyclerView_oder_product;

    public RecyclerView_Oder_KhachHang(Context context, List<Model_DonHang> listDH) {
        this.context = context;
        this.listDH = listDH;
    }

    @NonNull
    @Override
    public Holder_Oder_KhachHang onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcy_oder_khachhang, null);
        RecyclerView_Oder_KhachHang.Holder_Oder_KhachHang holderOder = new Holder_Oder_KhachHang(v);

        return holderOder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Oder_KhachHang holder, int position) {
        table_donHang = new Table_DonHang(context);
        table_khachHang = new Table_KhachHang(context);
        table_sanPham = new Table_SanPham(context);

        Model_DonHang model_donHang = listDH.get(position);

        holder.txt_oder_madh.setText(model_donHang.getMaDH() + "");
        holder.txt_oder_trangthai.setText(model_donHang.getTrangThai());
        holder.txt_oder_name.setText(model_donHang.getTenKH());
        holder.txt_oder_sdt.setText(model_donHang.getSDT() + "");
        holder.txt_oder_diachi.setText(model_donHang.getDiaChiKH());
        holder.txt_oder_tongtien.setText(model_donHang.getTongTien() + "");

        Model_KhachHang model_khachHang = new Model_KhachHang();
        SharedPreferences sharedPreferences = context.getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");
        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);
        List<Model_KhachHang> listMaKH = table_khachHang.checkKhachHang(model_khachHang);

        Model_DonHang model_donHang1 = new Model_DonHang();
        model_donHang1.setMaKH(listMaKH.get(0).getMaKH());

        model_donHang1.setMaDH(listDH.get(0).getMaKH());

        List<Model_DonHang> list = table_donHang.getSanPHamKhachHang(model_donHang1);
        list = table_donHang.getSanPHamKhachHang(model_donHang1);
        recyclerView_oder_product = new RecyclerView_Oder_Product(context, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rcy_oder.setLayoutManager(layoutManager);
        holder.rcy_oder.setAdapter(recyclerView_oder_product);
//        }
    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }

    public class Holder_Oder_KhachHang extends RecyclerView.ViewHolder {
        TextView txt_oder_madh, txt_oder_trangthai, txt_oder_name, txt_oder_sdt, txt_oder_diachi, txt_oder_tongtien;
        RecyclerView rcy_oder;
        public Holder_Oder_KhachHang(@NonNull View itemView) {
            super(itemView);
            txt_oder_madh = itemView.findViewById(R.id.txt_oder_madh);
            txt_oder_trangthai = itemView.findViewById(R.id.txt_oder_trangthai);
            txt_oder_name = itemView.findViewById(R.id.txt_oder_name);
            txt_oder_sdt = itemView.findViewById(R.id.txt_oder_sdt);
            txt_oder_diachi = itemView.findViewById(R.id.txt_oder_diachi);
            txt_oder_tongtien = itemView.findViewById(R.id.txt_oder_tongtien);
            rcy_oder = itemView.findViewById(R.id.rcy_oder);
        }
    }
}
