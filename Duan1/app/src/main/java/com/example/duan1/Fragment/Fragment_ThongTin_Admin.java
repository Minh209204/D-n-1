package com.example.duan1.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1.Activity.DanhSachKhachHang;
import com.example.duan1.Activity.DanhSachSanPham;
import com.example.duan1.Activity.Login;
import com.example.duan1.Database.Table_TaiKhoan;
import com.example.duan1.Model.Model_TaiKhoan;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_DSKhachHang;

import java.util.List;

public class Fragment_ThongTin_Admin extends Fragment {

    TextView thongtinAmin, qlsanpham, qlkhachhang, dangxuat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_thongtin_admin, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        thongtinAmin = view.findViewById(R.id.thongtinAdmin);
        qlsanpham = view.findViewById(R.id.qlsanpham);
        qlkhachhang = view.findViewById(R.id.qlkhachhang);
        dangxuat = view.findViewById(R.id.dangxuat);

        qlsanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getActivity(), DanhSachSanPham.class));
            }
        });

        qlkhachhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DanhSachKhachHang.class));
            }
        });

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_dangxuat();
            }
        });
    }

    public void dialog_dangxuat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Đăng xuất");
        builder.setMessage("Bạn có chắc muốn đăng xuất tài khoản");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getActivity(), Login.class));
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
