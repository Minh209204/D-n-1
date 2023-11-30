package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Database.Table_GioHang;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.Model_GioHang;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Model_SanPham pham = new Model_SanPham();
        table_sanPham = new Table_SanPham(this);
        table_gioHang = new Table_GioHang(this);
        Intent intent = getIntent();

        img_product = findViewById(R.id.img_product);
        txt_product_name = findViewById(R.id.txt_product_name);
        txt_product_price = findViewById(R.id.txt_product_price);
        txt_product_gioiThieu = findViewById(R.id.txt_product_gioiThieu);
        btnAdd = findViewById(R.id.btn_add);
        toolbar_product =findViewById(R.id.toolbar_product);

        setSupportActionBar(toolbar_product);
        getSupportActionBar().setTitle("Chi tiết sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int masp = intent.getIntExtra("masp", 1);
        pham.setMaSP(masp);

        List<Model_SanPham> list = table_sanPham.getMASP(pham);

        Picasso.get().load(list.get(0).getAnhSP()).into(img_product);
        txt_product_name.setText(list.get(0).getTenSP());
        txt_product_price.setText(list.get(0).getGiaTienSP() + "");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model_GioHang hoaDon = new Model_GioHang();
                String img = list.get(0).getAnhSP().toString();
                String ten = list.get(0).getTenSP();
                int gia = list.get(0).getGiaTienSP();

                hoaDon.setAnhSP(img);
                hoaDon.setGiaSP(gia);
                hoaDon.setTenSP(ten);

                if (table_gioHang.insert(hoaDon)){
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