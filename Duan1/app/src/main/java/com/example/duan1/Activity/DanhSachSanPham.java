package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.duan1.R;

public class DanhSachSanPham extends AppCompatActivity {
    Toolbar toolbar_sanpham;
    RecyclerView rcy_qlsanpham;
    ImageButton btn_add_product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlsan_pham);

        toolbar_sanpham = findViewById(R.id.toolbar_sanpham);
        rcy_qlsanpham = findViewById(R.id.rcy_qlsanpham);
        btn_add_product = findViewById(R.id.btn_add_product);

        setSupportActionBar(toolbar_sanpham);
        getSupportActionBar().setTitle("Danh sách sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DanhSachSanPham.this, Create_Product.class));
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






//    public void dialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        View v = View.inflate(this, R.layout.dialog_create_product, null);
//        builder.setView(v);
//        AlertDialog dialog = builder.create();
//
//        table_qlSanPham = new Table_QLSanPham(this);
//        qlSanPham = new Model_QLSanPham();
//
//        EditText edt_name = v.findViewById(R.id.edt_name);
//        EditText edt_price = v.findViewById(R.id.edt_price);
//        EditText edt_anh = v.findViewById(R.id.edt_anh);
//        EditText edt_gioithieu = v.findViewById(R.id.edt_gioithieu);
//        Button btn_create = v.findViewById(R.id.btn_create);
//
//        btn_create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = edt_name.getText().toString();
//                String price = edt_price.getText().toString();
//                String anh = edt_anh.getText().toString();
//                String gioithieu = edt_gioithieu.getText().toString();
//
//                qlSanPham.setTenSP(name);
//                qlSanPham.setGiaSP(price);
//                qlSanPham.setAnhSP(anh);
//                qlSanPham.setGioiThieuSP(gioithieu);
//
//                if (table_qlSanPham.insert(qlSanPham)){
//                    Toast.makeText(DanhSachSanPham.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(DanhSachSanPham.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        dialog.show();
//    }

}