package com.example.duan1.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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
import java.util.Arrays;
import java.util.List;

public class RecyclerView_Oder_Admin extends RecyclerView.Adapter<RecyclerView_Oder_Admin.Holder_Oder_Admin>{
    Context context;
    List<Model_DonHang> listDH;
    Table_DonHang table_donHang;
    Table_KhachHang table_khachHang;
    Table_SanPham table_sanPham;
    Table_GioHang table_gioHang;
    Model_GioHang model_gioHang;
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
        table_gioHang = new Table_GioHang(context);

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
                huy(model_donHang);
                holder.layout_trangthai.setVisibility(View.GONE);

            }
        });
        holder.btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xacnhan(model_donHang);
                holder.layout_trangthai.setVisibility(View.GONE);
                String MaGH = model_donHang.getMaGH();
                String Soluong = model_donHang.getSoLuongSP();
                if (MaGH.length() > 1){
                    String arrMaGh[] = MaGH.split(",");
                    String arrSoluong[] = Soluong.split(",");
                    for (int i=0 ; i < arrMaGh.length; i++){
                        model_gioHang = new Model_GioHang();
                        model_gioHang.setMaGH(Integer.parseInt(arrMaGh[i]));

                        List<Model_GioHang> listGH = table_gioHang.getSanPhamTheoMaGH(model_gioHang);

                        Model_SanPham model_sanPham = new Model_SanPham();
                        model_sanPham.setMaSP(listGH.get(0).getMaSP());

                        List<Model_SanPham> listSP = table_sanPham.getMASP(model_sanPham);
                        int tongSoLuong = listSP.get(0).getLuotMuaSP();
                        model_sanPham.setMaTL(listSP.get(0).getMaTL());
                        model_sanPham.setTenTL(listSP.get(0).getTenTL());
                        model_sanPham.setTenSP(listSP.get(0).getTenSP());
                        model_sanPham.setGiaTienSP(listSP.get(0).getGiaTienSP());
                        model_sanPham.setAnhSP(listSP.get(0).getAnhSP());
                        model_sanPham.setLuotMuaSP(tongSoLuong += Integer.parseInt(arrSoluong[i]));
                        model_sanPham.setGioiThieuSP(listSP.get(0).getGioiThieuSP());
                        model_sanPham.setSoLuong(listSP.get(0).getSoLuong());

                        if (table_sanPham.update(model_sanPham)){
                            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else if (MaGH.length() == 1) {
                    model_gioHang = new Model_GioHang();
                    model_gioHang.setMaGH(Integer.parseInt(MaGH));

                    List<Model_GioHang> listGH = table_gioHang.getSanPhamTheoMaGH(model_gioHang);

                    Model_SanPham model_sanPham = new Model_SanPham();
                    model_sanPham.setMaSP(listGH.get(0).getMaSP());

                    List<Model_SanPham> listSP = table_sanPham.getMASP(model_sanPham);
                    int tongSoLuong = listSP.get(0).getLuotMuaSP();
                    model_sanPham.setMaTL(listSP.get(0).getMaTL());
                    model_sanPham.setTenTL(listSP.get(0).getTenTL());
                    model_sanPham.setTenSP(listSP.get(0).getTenSP());
                    model_sanPham.setGiaTienSP(listSP.get(0).getGiaTienSP());
                    model_sanPham.setAnhSP(listSP.get(0).getAnhSP());
                    model_sanPham.setLuotMuaSP(tongSoLuong += Integer.parseInt(Soluong));
                    model_sanPham.setGioiThieuSP(listSP.get(0).getGioiThieuSP());
                    model_sanPham.setSoLuong(listSP.get(0).getSoLuong());

                    if (table_sanPham.update(model_sanPham)){
                        Toast.makeText(context, "okokokokok", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //san pham vao recyclerview
        List<Model_DonHang> listAllDH = table_donHang.getAll();
        List<Model_DonHang> listDHSanPham = new ArrayList<>();
        String MaSP = String.valueOf(listAllDH.get(position).getMaGH());
        String SoluongSP = String.valueOf(listAllDH.get(position).getSoLuongSP());

        if (MaSP.length() > 1){
            String arraySP[] = MaSP.split(",");
            String arraySlSP[] = SoluongSP.split(",");
            for (int i=0; i < arraySP.length; i++){
                model_gioHang = new Model_GioHang();
                model_gioHang.setMaGH(Integer.parseInt(arraySP[i]));

                List<Model_GioHang> listGH1 = table_gioHang.getSanPhamTheoMaGH(model_gioHang);

                Model_DonHang model_donHang1 = new Model_DonHang();

                model_donHang1.setTenSP(listGH1.get(0).getTenSP());
                model_donHang1.setGiaSP(listGH1.get(0).getGiaSP());
                model_donHang1.setSoLuongSP(String.valueOf(listGH1.get(0).getSoLuongSP()));
                model_donHang1.setAnhSP(listGH1.get(0).getAnhSP());
                model_donHang1.setSoLuongSP(arraySlSP[i]);
                listDHSanPham.add(model_donHang1);
            }
            recyclerView_oder_product = new RecyclerView_Oder_Product(context, listDHSanPham);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            holder.rcy_oder.setLayoutManager(layoutManager);
            holder.rcy_oder.setAdapter(recyclerView_oder_product);

        }else if (MaSP.length() == 1){
            model_gioHang = new Model_GioHang();
            model_gioHang.setMaGH(Integer.parseInt(model_donHang.getMaGH()));
            List<Model_GioHang> listGH = table_gioHang.getSanPhamTheoMaGH(model_gioHang);
            model_donHang.setTenSP(listGH.get(0).getTenSP());
            model_donHang.setGiaSP(listGH.get(0).getGiaSP());
            model_donHang.setAnhSP(listGH.get(0).getAnhSP());
            model_donHang.setSoLuongSP(String.valueOf(listGH.get(0).getSoLuongSP()));
            listDHSanPham.add(model_donHang);

            recyclerView_oder_product = new RecyclerView_Oder_Product(context, listDHSanPham);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            holder.rcy_oder.setLayoutManager(layoutManager);
            holder.rcy_oder.setAdapter(recyclerView_oder_product);
        }else {
            Toast.makeText(context, "Xuất giỏ hàng thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }

    public class Holder_Oder_Admin extends RecyclerView.ViewHolder {
        TextView txt_oder_madh, txt_oder_trangthai, txt_oder_name, txt_oder_sdt, txt_oder_diachi, txt_oder_tongtien;
        RecyclerView rcy_oder;
        Button btn_huy, btn_xacnhan;
        LinearLayout layout_trangthai;
        public Holder_Oder_Admin(@NonNull View itemView) {
            super(itemView);
            txt_oder_madh = itemView.findViewById(R.id.txt_oder_madh);
            txt_oder_trangthai = itemView.findViewById(R.id.txt_oder_trangthai);
            txt_oder_name = itemView.findViewById(R.id.txt_oder_name);
            txt_oder_sdt = itemView.findViewById(R.id.txt_oder_sdt);
            txt_oder_diachi = itemView.findViewById(R.id.txt_oder_diachi);
            txt_oder_tongtien = itemView.findViewById(R.id.txt_oder_tongtien);
            btn_huy = itemView.findViewById(R.id.btn_huy);
            layout_trangthai = itemView.findViewById(R.id.layout_trangthai);
            btn_xacnhan = itemView.findViewById(R.id.btn_xacnhan);
            rcy_oder = itemView.findViewById(R.id.rcy_oder_admin);

        }
    }

    public void huy(Model_DonHang model_donHang){
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

    public void xacnhan(Model_DonHang model_donHang){
        model_donHang.getMaDH();
        model_donHang.setTrangThai("Đã xác nhận");
        if (table_donHang.update(model_donHang)){
            notifyDataSetChanged();
            Toast.makeText(context, "Xác nhận đơn thành công", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Xác nhận thất bại", Toast.LENGTH_SHORT).show();
        }
    }

//    public void update_soluongSP(Model_DonHang model_donHang){
//        mo
//
//
//    }
}
