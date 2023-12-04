package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Fragment.Fragment_ThongTin_KhacHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ThongTinCaNhan extends AppCompatActivity {
    Toolbar toolbar;
    ImageView img_kh;
    Button btn_hoanThanh;
    EditText edt_name_kh, edt_account_kh, edt_password_kh, edt_sdt_kh, edt_address_kh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        Table_KhachHang table_khachHang = new Table_KhachHang(this);
        Model_KhachHang model_khachHang = new Model_KhachHang();

        toolbar = findViewById(R.id.toolbar);
        img_kh = findViewById(R.id.img_kh);
        btn_hoanThanh = findViewById(R.id.btn_hoanThanh);
        edt_name_kh = findViewById(R.id.edt_name_kh);
        edt_account_kh = findViewById(R.id.edt_account_kh);
        edt_password_kh = findViewById(R.id.edt_password_kh);
        edt_sdt_kh = findViewById(R.id.edt_sdt_kh);
        edt_address_kh = findViewById(R.id.edt_address_kh);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thông tin cá nhân");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau =sharedPreferences.getString("matkhau", "");

        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);

        List<Model_KhachHang> list = table_khachHang.checkKhachHang(model_khachHang);

        Picasso.get().load(list.get(0).getAnhKH()).into(img_kh);
        edt_name_kh.setText(list.get(0).getTenKH());
        edt_account_kh.setText(list.get(0).getTaiKhoan());
        edt_password_kh.setText(list.get(0).getMatKhau());
        edt_sdt_kh.setText(list.get(0).getSDTKH());
        edt_address_kh.setText(list.get(0).getDiaChiKH());

        btn_hoanThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name_kh.getText().toString();
                String account = edt_account_kh.getText().toString();
                String password = edt_password_kh.getText().toString();
                String sdt = edt_sdt_kh.getText().toString();
                String address = edt_address_kh.getText().toString();

                Toast.makeText(ThongTinCaNhan.this, list.get(0).getMaKH() + "", Toast.LENGTH_SHORT).show();

                model_khachHang.setAnhKH(list.get(0).getAnhKH());
                model_khachHang.setMaKH(list.get(0).getMaKH());
                model_khachHang.setTenKH(name);
                model_khachHang.setTaiKhoan(account);
                model_khachHang.setMatKhau(password);
                model_khachHang.setSDTKH(sdt);
                model_khachHang.setDiaChiKH(address);

                if (table_khachHang.update(model_khachHang)){
                    Toast.makeText(ThongTinCaNhan.this, "Thay đổi thông tin thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ThongTinCaNhan.this, "Thay đổi thông tin thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}