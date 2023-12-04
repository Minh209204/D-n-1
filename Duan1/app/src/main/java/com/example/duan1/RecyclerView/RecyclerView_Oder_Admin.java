package com.example.duan1.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Oder_Admin extends RecyclerView.Adapter<RecyclerView_Oder_Admin.Holder_Oder_Admin>{
    Context context;
    List<Model_DonHang> listDH;
    Table_DonHang table_donHang;
    Table_KhachHang table_khachHang;
    Table_SanPham table_sanPham;
    RecyclerView_Oder_Product recyclerView_oder_product;

    public RecyclerView_Oder_Admin(Context context, List<Model_DonHang> listDH) {
        this.context = context;
        this.listDH = listDH;
    }

    @NonNull
    @Override
    public Holder_Oder_Admin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.rcy_oder_admin, null);
        RecyclerView_Oder_Admin.Holder_Oder_Admin holderOder = new Holder_Oder_Admin(v);

        return holderOder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Oder_Admin holder, int position) {
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
        holder.btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model_donHang.getMaDH();
                if (table_donHang.delete(model_donHang)){
                    listDH.clear();
                    listDH = table_donHang.getAll();
                    notifyDataSetChanged();
                    Toast.makeText(context, "Xóa đơn hàng thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        holder.btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model_donHang.getMaDH();
                model_donHang.setTrangThai("Đã xác nhận");
                if (table_donHang.update(model_donHang)){
                    notifyDataSetChanged();
                    Toast.makeText(context, "Xác nhận đơn thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Xác nhận thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        List<Model_DonHang> listDH = table_donHang.getAll();

        recyclerView_oder_product = new RecyclerView_Oder_Product(context, listDH);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rcy_oder.setLayoutManager(layoutManager);
        holder.rcy_oder.setAdapter(recyclerView_oder_product);

    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }

    public class Holder_Oder_Admin extends RecyclerView.ViewHolder {
        TextView txt_oder_madh, txt_oder_trangthai, txt_oder_name, txt_oder_sdt, txt_oder_diachi, txt_oder_tongtien;
        RecyclerView rcy_oder;
        Button btn_huy, btn_xacnhan;
        public Holder_Oder_Admin(@NonNull View itemView) {
            super(itemView);
            txt_oder_madh = itemView.findViewById(R.id.txt_oder_madh);
            txt_oder_trangthai = itemView.findViewById(R.id.txt_oder_trangthai);
            txt_oder_name = itemView.findViewById(R.id.txt_oder_name);
            txt_oder_sdt = itemView.findViewById(R.id.txt_oder_sdt);
            txt_oder_diachi = itemView.findViewById(R.id.txt_oder_diachi);
            txt_oder_tongtien = itemView.findViewById(R.id.txt_oder_tongtien);
            btn_huy = itemView.findViewById(R.id.btn_huy);
            btn_xacnhan = itemView.findViewById(R.id.btn_xacnhan);
            rcy_oder = itemView.findViewById(R.id.rcy_oder);

        }
    }
}
