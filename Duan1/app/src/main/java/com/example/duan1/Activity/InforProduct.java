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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Database.Table_GioHang;
import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_GioHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InforProduct extends AppCompatActivity {
    ImageView img_product;
    TextView txt_product_name, txt_product_price, txt_product_gioiThieu;
    Button btnAdd;
    Toolbar toolbar_product;
    Table_SanPham table_sanPham;
    Table_GioHang table_gioHang;
    Table_KhachHang table_khachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Model_SanPham model_SanPham = new Model_SanPham();
        Model_KhachHang model_khachHang = new Model_KhachHang();
        table_khachHang = new Table_KhachHang(this);
        table_sanPham = new Table_SanPham(this);
        table_gioHang = new Table_GioHang(this);

        img_product = findViewById(R.id.img_product);
        txt_product_name = findViewById(R.id.txt_product_name);
        txt_product_price = findViewById(R.id.txt_product_price);
        txt_product_gioiThieu = findViewById(R.id.txt_product_gioiThieu);
        btnAdd = findViewById(R.id.btn_add);
        toolbar_product =findViewById(R.id.toolbar_product);

        setSupportActionBar(toolbar_product);
        getSupportActionBar().setTitle("Chi tiết sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE);
        String taikhoan = sharedPreferences.getString("taikhoan", "");
        String matkhau = sharedPreferences.getString("matkhau", "");

        //lay ra khach hang
        model_khachHang.setTaiKhoan(taikhoan);
        model_khachHang.setMatKhau(matkhau);
        List<Model_KhachHang> listKH = table_khachHang.checkKhachHang(model_khachHang);

        //lay ra san pham
        Intent intent = getIntent();
        int masp = intent.getIntExtra("masp", -1);
        model_SanPham.setMaSP(masp);
        List<Model_SanPham> list = table_sanPham.getMASP(model_SanPham);

        Picasso.get().load(list.get(0).getAnhSP()).into(img_product);
        txt_product_name.setText(list.get(0).getTenSP());
        txt_product_price.setText(list.get(0).getGiaTienSP() + "");
        txt_product_gioiThieu.setText(list.get(0).getGioiThieuSP());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model_GioHang model_gioHang = new Model_GioHang();
                int masp = list.get(0).getMaSP();
                String img = list.get(0).getAnhSP().toString();
                String ten = list.get(0).getTenSP();
                int gia = list.get(0).getGiaTienSP();

                model_gioHang.setMaKH(listKH.get(0).getMaKH());
                model_gioHang.setMaSP(masp);
                model_gioHang.setAnhSP(img);
                model_gioHang.setGiaSP(gia);
                model_gioHang.setTenSP(ten);
                model_gioHang.setSoLuongSP(1);
                model_gioHang.setCheckBox(0);
                model_gioHang.setTonTai(1);

                if (table_gioHang.insert(model_gioHang)){
                    Toast.makeText(InforProduct.this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(InforProduct.this, "Thêm vào giỏ hàng thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}