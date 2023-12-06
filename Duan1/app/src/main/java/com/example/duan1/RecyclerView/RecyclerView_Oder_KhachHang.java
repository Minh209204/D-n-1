package com.example.duan1.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_DonHang;
import com.example.duan1.Database.Table_GioHang;
import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.Model.Model_GioHang;
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
    Table_GioHang table_gioHang;
    Model_GioHang model_gioHang;
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
        table_gioHang = new Table_GioHang(context);

        Model_DonHang model_donHang = listDH.get(position);

        holder.txt_oder_madh.setText(model_donHang.getMaDH() + "");
        holder.txt_oder_trangthai.setText(model_donHang.getTrangThai());
        holder.txt_oder_name.setText(model_donHang.getTenKH());
        holder.txt_oder_sdt.setText(model_donHang.getSDT() + "");
        holder.txt_oder_diachi.setText(model_donHang.getDiaChiKH());
        holder.txt_oder_tongtien.setText(model_donHang.getTongTien() + "");

        //tim khach hang theo taikhoan va matkhau khi dang nhap
        Model_KhachHang model_khachHang = new Model_KhachHang();
        SharedPreferences sharedPreferences = context.getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");
        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);
        List<Model_KhachHang> listMaKH = table_khachHang.checkKhachHang(model_khachHang);
        Model_DonHang model_donHang1 = new Model_DonHang();
        model_donHang1.setMaKH(listMaKH.get(0).getMaKH());

        List<Model_DonHang> listGetAllDH = table_donHang.getHoaDonKhachHang(model_donHang1);
        List<Model_DonHang> listDH = new ArrayList<>();

        String MaGH = String.valueOf(model_donHang.getMaGH());
        String SoluongSP = String.valueOf(listGetAllDH.get(position).getSoLuongSP());

        Log.d("TAG", "onBindViewHolder123: " + SoluongSP + "");

        if (MaGH.length() > 1){
            String arraySP[] = MaGH.split(",");
            String arraySlSP[] = SoluongSP.split(",");
            for (int i=0; i < arraySP.length; i++){
                model_gioHang = new Model_GioHang();
                model_gioHang.setMaGH(Integer.parseInt(arraySP[i]));

                List<Model_GioHang> listGH = table_gioHang.getSanPhamTheoMaGH(model_gioHang);

                Model_DonHang model_donHang2 = new Model_DonHang();

                model_donHang2.setTenSP(listGH.get(0).getTenSP());
                model_donHang2.setGiaSP(listGH.get(0).getGiaSP());
                model_donHang2.setSoLuongSP(String.valueOf(listGH.get(0).getSoLuongSP()));
                model_donHang2.setAnhSP(listGH.get(0).getAnhSP());
                model_donHang2.setSoLuongSP(arraySlSP[i]);
                listDH.add(model_donHang2);
            }
            recyclerView_oder_product = new RecyclerView_Oder_Product(context, listDH);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            holder.rcy_oder.setLayoutManager(layoutManager);
            holder.rcy_oder.setAdapter(recyclerView_oder_product);

        }else if (MaGH.length() == 1){
            model_gioHang = new Model_GioHang();
            model_gioHang.setMaGH(Integer.parseInt(model_donHang.getMaGH()));
            List<Model_GioHang> listGH = table_gioHang.getSanPhamTheoMaGH(model_gioHang);

            model_donHang.setTenSP(listGH.get(0).getTenSP());
            model_donHang.setGiaSP(listGH.get(0).getGiaSP());
            model_donHang.setAnhSP(listGH.get(0).getAnhSP());
            model_donHang.setSoLuongSP(String.valueOf(listGH.get(0).getSoLuongSP()));
            listDH.add(model_donHang);

            recyclerView_oder_product = new RecyclerView_Oder_Product(context, listDH);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            holder.rcy_oder.setLayoutManager(layoutManager);
            holder.rcy_oder.setAdapter(recyclerView_oder_product);
        }else {
            Toast.makeText(context, "Lấy sản phẩm thất bại", Toast.LENGTH_SHORT).show();
        }
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
            rcy_oder = itemView.findViewById(R.id.rcy_oder_kh);
        }
    }
}
