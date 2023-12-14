package com.example.duan1.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_GioHang;
import com.example.duan1.Database.Table_DonHang;
import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.EventBus.Event_TongTien_Cart;
import com.example.duan1.Model.Model_DonHang;
import com.example.duan1.Model.Model_GioHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_Cart;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Cart extends Fragment {
    Table_GioHang table_gioHang;
    Table_KhachHang table_khachHang;
    Table_DonHang table_donHang;
    List<Model_GioHang> listGH;
    RecyclerView_Cart recyclerView_cart;
    RecyclerView recyclerView;
    TextView txt_tong;
    LinearLayout layout_cart;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        table_gioHang = new Table_GioHang(getContext());
        table_khachHang = new Table_KhachHang(getContext());
        table_donHang = new Table_DonHang(getContext());
        Model_KhachHang model_khachHang = new Model_KhachHang();
        Model_GioHang model_gioHang = new Model_GioHang();

        recyclerView = view.findViewById(R.id.recyclerView);
        txt_tong = view.findViewById(R.id.txt_tong);
        layout_cart = view.findViewById(R.id.layout_cart);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");
        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);

        List<Model_KhachHang> listKH = table_khachHang.checkKhachHang(model_khachHang);
        model_gioHang.setTonTai(1);
        model_gioHang.setMaKH(listKH.get(0).getMaKH());

        listGH = table_gioHang.getAll(model_gioHang);
        recyclerView_cart = new RecyclerView_Cart(getContext(), listGH);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(recyclerView_cart);
        recyclerView.setLayoutManager(layoutManager);

        layout_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_gioHang = new Table_GioHang(getContext());
                Model_GioHang model_gioHang = new Model_GioHang();
                model_gioHang.setMaKH(listKH.get(0).getMaKH());
                model_gioHang.setCheckBox(1);
                listGH = table_gioHang.getSanPhamDuocMua(model_gioHang);
                if (listGH.size() != 0){
                    MuaSanPham();
                }else {
                    Toast.makeText(getContext(), "Vui lòng chọn sản phẩm", Toast.LENGTH_SHORT).show();
                }

            }
        });
        tinhTong();
    }



    public void MuaSanPham(){
        int tong = 0;

        //lay ra khach hang
        table_khachHang = new Table_KhachHang(getContext());
        Model_KhachHang model_khachHang = new Model_KhachHang();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");
        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);
        List<Model_KhachHang> listMaKH = table_khachHang.checkKhachHang(model_khachHang);

        //tim san pham theo checkbox
        table_gioHang = new Table_GioHang(getContext());
        Model_GioHang model_gioHang = new Model_GioHang();
        model_gioHang.setMaKH(listMaKH.get(0).getMaKH());
        model_gioHang.setCheckBox(1);
        listGH = table_gioHang.getSanPhamDuocMua(model_gioHang);

        //luu vao don hang
        table_donHang = new Table_DonHang(getContext());
        Model_DonHang model_donHang = new Model_DonHang();
        List<Model_DonHang> listDH = new ArrayList<>();

        //check so luong san pham duoc mua
        for (int i=0; i<listGH.size(); i++){
            String magh = String.valueOf(listGH.get(i).getMaGH());
            int makh = listGH.get(i).getMaKH();
            int masp = listGH.get(i).getMaSP();
            String tensp = listGH.get(i).getTenSP();
            String anhsp = listGH.get(i).getAnhSP();
            String soLuong = String.valueOf(listGH.get(i).getSoLuongSP());
            int giaSanPham = listGH.get(i).getGiaSP();

            model_donHang = new Model_DonHang();

            model_donHang.setMaGH(magh);
            model_donHang.setMaKH(makh);
            model_donHang.setMaSP(masp);
            model_donHang.setTenSP(tensp);
            model_donHang.setAnhSP(anhsp);
            model_donHang.setSoLuongSP(soLuong);
            model_donHang.setGiaSP(giaSanPham);

            listDH.add(model_donHang);
        }

        //noi chuoi nhung san pham duoc chon theo MAGH
        String arrMaGh = null;
        String arrSoluongSP = null;
        if (listDH.size() > 1){
            arrMaGh = String.valueOf(listGH.get(0).getMaGH());
            arrSoluongSP = String.valueOf(listDH.get(0).getSoLuongSP());
            for (int i=1; i<listDH.size(); i++){
                String magh = String.valueOf(listGH.get(i).getMaGH());
                String soluongsp = String.valueOf(listDH.get(i).getSoLuongSP());
                arrMaGh += "," + magh;
                arrSoluongSP += "," + soluongsp;
            }
        }else if (listDH.size() == 1){
            arrMaGh = String.valueOf(listGH.get(0).getMaGH());
            arrSoluongSP = String.valueOf(listGH.get(0).getSoLuongSP());
        }else {
            Toast.makeText(getContext(), "Lỗi tại giỏ hàng", Toast.LENGTH_SHORT).show();
        }

        //set tong tien gio hang
        for (int i=0; i<listDH.size(); i++){
            int soLuong = listGH.get(i).getSoLuongSP();
            int giaSanPham = listGH.get(i).getGiaSP();
            tong += soLuong * giaSanPham;
        }

        model_donHang.setMaKH(listMaKH.get(0).getMaKH());
        List<Model_KhachHang> listKH = table_khachHang.getKhachHang(model_donHang);

        Model_DonHang model_donHang1 = new Model_DonHang();

        model_donHang1.setMaGH(arrMaGh);
        model_donHang1.setMaKH(model_gioHang.getMaKH());
        model_donHang1.setTenKH(listKH.get(0).getTenKH());
        model_donHang1.setSDT(Integer.parseInt(listKH.get(0).getSDTKH()));
        model_donHang1.setDiaChiKH(listKH.get(0).getDiaChiKH());
        model_donHang1.setSoLuongSP(arrSoluongSP);
        model_donHang1.setTongTien(tong);
        model_donHang1.setTrangThai("Chờ xác nhận");

        if (table_donHang.insert(model_donHang1)){
            Toast.makeText(getContext(), "Tạo đơn hàng thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "Tạo đơn hàng thất bại", Toast.LENGTH_SHORT).show();
        }
        txt_tong.setText(tong +"");
    }

    //set tong tien vao text gio hang
    public void tinhTong(){
        int tong = 0;

        //lay id theo tai khoan mat khau
        Model_KhachHang model_khachHang = new Model_KhachHang();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");
        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);
        List<Model_KhachHang> listKH = table_khachHang.checkKhachHang(model_khachHang);

        table_gioHang = new Table_GioHang(getContext());
        Model_GioHang model_gioHang = new Model_GioHang();
        model_gioHang.setCheckBox(1);
        model_gioHang.setMaKH(listKH.get(0).getMaKH());
        listGH = table_gioHang.getSanPhamDuocMua(model_gioHang);

        //lay tong so tien cua san pham trong gio hang
        for (int i=0; i<listGH.size(); i++){
            int soLuong = listGH.get(i).getSoLuongSP();
            int giaSanPham = listGH.get(i).getGiaSP();
            tong += soLuong * giaSanPham;
        }
        txt_tong.setText(tong +"");
    }
    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }
    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void tinhTongTien(Event_TongTien_Cart eventTongTienCart){
        if (eventTongTienCart != null){
            tinhTong();
        }
    }
}
