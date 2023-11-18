package com.example.duan1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Model.SanPham;
import com.example.duan1.R;

public class Product extends AppCompatActivity {
    ImageView img_product;
    TextView txt_product_name, txt_product_price;
    Button btnAdd;
    SanPham pham;
    Table_SanPham table_sanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        pham = new SanPham();
        table_sanPham = new Table_SanPham(this);

        img_product = findViewById(R.id.img_product);
        txt_product_name = findViewById(R.id.txt_product_name);
        txt_product_price = findViewById(R.id.txt_product_price);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pham.setTenSp(txt_product_name.getText().toString());
                pham.setGiaTien(Integer.parseInt(txt_product_price.getText().toString()));

                if (table_sanPham.insert(pham)){
                    startActivity(new Intent(Product.this, Main.class));
                }
            }
        });
    }
}