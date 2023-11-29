package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1.DataHelper.Adapter_TheLoai;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Database.Table_TheLoai;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.Model.Model_TheLoai;
import com.example.duan1.R;

import java.util.List;

public class Create_Product extends AppCompatActivity {
    Adapter_TheLoai adapter_theLoai;
    Table_TheLoai table_theLoai;
    Model_TheLoai model_theLoai;
    Table_SanPham table_sanPham;
    Model_SanPham model_sanPham;
    Spinner spinner;
    Toolbar toolbar_createSP;
    EditText edt_name, edt_price, edt_anh, edt_gioithieu;
    Button btn_create;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        table_sanPham = new Table_SanPham(this);
        table_theLoai = new Table_TheLoai(this);
        model_theLoai = new Model_TheLoai();

        spinner = findViewById(R.id.spinner);
        toolbar_createSP = findViewById(R.id.toolbar_createSP);
        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);
        edt_anh = findViewById(R.id.edt_anh);
        edt_gioithieu = findViewById(R.id.edt_gioithieu);
        btn_create = findViewById(R.id.btn_create);

        setSupportActionBar(toolbar_createSP);
        getSupportActionBar().setTitle("Tạo sản phẩm");

        List<Model_TheLoai> list = table_theLoai.getAll();


        adapter_theLoai = new Adapter_TheLoai(list, Create_Product.this);
        spinner.setAdapter(adapter_theLoai);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model_sanPham = new Model_SanPham();
                String name = edt_name.getText().toString();
                String price = edt_price.getText().toString();
                String theloai = list.get(index).getTenTL();
                String anh = edt_anh.getText().toString();
                String gioithieu = edt_gioithieu.getText().toString();
                int matl = index;

                model_sanPham.setTenSP(name);
                model_sanPham.setTenTL(theloai);
                model_sanPham.setMaTL(matl);
                model_sanPham.setGiaTienSP(Integer.parseInt(price));
                model_sanPham.setAnhSP(anh);
                model_sanPham.setGioiThieuSP(gioithieu);
                model_sanPham.setTonTai(1);
                if (table_sanPham.insert(model_sanPham)){
                    Toast.makeText(Create_Product.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Create_Product.this, DanhSachSanPham.class));
                }else {
                    Toast.makeText(Create_Product.this, "Thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}