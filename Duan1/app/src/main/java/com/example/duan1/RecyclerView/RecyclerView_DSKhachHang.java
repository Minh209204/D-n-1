package com.example.duan1.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;

import java.util.List;

public class RecyclerView_DSKhachHang extends RecyclerView.Adapter<RecyclerView_DSKhachHang.Holder_KhachHang>{

    Context context;
    List<Model_KhachHang> list;
    Table_KhachHang table_taiKhoan;

    public RecyclerView_DSKhachHang(Context context, List<Model_KhachHang> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_KhachHang onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.rcy_dskhachhang, null);

        RecyclerView_DSKhachHang.Holder_KhachHang holder_khachHang = new Holder_KhachHang(v);
        return holder_khachHang;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_KhachHang holder, int position) {
        Model_KhachHang model_taiKhoan = list.get(position);
        table_taiKhoan = new Table_KhachHang(context);

        holder.txt_qlkh_name.setText(model_taiKhoan.getTenKH());
        holder.txt_qlkh_account.setText(model_taiKhoan.getTaiKhoan());
        holder.txt_qlkh_password.setText(model_taiKhoan.getMatKhau());
        holder.txt_qlkh_sdt.setText(model_taiKhoan.getSDTKH() + "");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_KhachHang extends RecyclerView.ViewHolder {
        TextView txt_qlkh_name, txt_qlkh_account, txt_qlkh_password, txt_qlkh_sdt;
        public Holder_KhachHang(@NonNull View itemView) {
            super(itemView);
            txt_qlkh_name = itemView.findViewById(R.id.txt_qlkh_name);
            txt_qlkh_account = itemView.findViewById(R.id.txt_qlkh_account);
            txt_qlkh_password = itemView.findViewById(R.id.txt_qlkh_password);
            txt_qlkh_sdt = itemView.findViewById(R.id.txt_qlkh_sdt);
        }
    }

}
