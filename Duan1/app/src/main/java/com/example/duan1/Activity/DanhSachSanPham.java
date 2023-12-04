package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1.DataHelper.Adapter_TheLoai;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Database.Table_TheLoai;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.Model.Model_TheLoai;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecyclerView_DSSanpham;

import java.util.List;

public class DanhSachSanPham extends AppCompatActivity {
    Adapter_TheLoai adapter_theLoai;
    Toolbar toolbar_sanpham;
    RecyclerView rcy_qlsanpham;
    ImageButton btn_add_product;
    Table_SanPham table_sanPham;
    RecyclerView_DSSanpham recyclerView_dsSanpham;
    Table_TheLoai table_theLoai;
    Model_TheLoai model_theLoai;
    Model_SanPham model_sanPham;
    Spinner spinner;
    EditText edt_name, edt_price, edt_soluong, edt_anh, edt_gioithieu;
    Button btn_create;
    int index;
    List<Model_SanPham> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachsanpham);

        table_sanPham = new Table_SanPham(this);
        table_theLoai = new Table_TheLoai(this);
        table_sanPham = new Table_SanPham(DanhSachSanPham.this);


        toolbar_sanpham = findViewById(R.id.toolbar_sanpham);
        rcy_qlsanpham = findViewById(R.id.rcy_qlsanpham);
        btn_add_product = findViewById(R.id.btn_add_product);

        setSupportActionBar(toolbar_sanpham);
        getSupportActionBar().setTitle("Danh sách sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = table_sanPham.getAll();
        recyclerView_dsSanpham = new RecyclerView_DSSanpham(DanhSachSanPham.this, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(DanhSachSanPham.this, RecyclerView.VERTICAL, false);
        rcy_qlsanpham.setLayoutManager(layoutManager);
        rcy_qlsanpham.setAdapter(recyclerView_dsSanpham);
        btn_add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DanhSachSanPham.this);
                View v = View.inflate(DanhSachSanPham.this, R.layout.dialog_create_product, null);
                builder.setView(v);
                AlertDialog dialog = builder.create();

                model_theLoai = new Model_TheLoai();

                spinner = v.findViewById(R.id.spinner);
                edt_name = v.findViewById(R.id.edt_name);
                edt_price = v.findViewById(R.id.edt_price);
                edt_soluong = v.findViewById(R.id.edt_soluong);
                edt_anh = v.findViewById(R.id.edt_anh);
                edt_gioithieu = v.findViewById(R.id.edt_gioithieu);
                btn_create = v.findViewById(R.id.btn_create);

                List<Model_TheLoai> listTL = table_theLoai.getAll();

                adapter_theLoai = new Adapter_TheLoai(listTL, DanhSachSanPham.this);
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
                        String theloai = listTL.get(index).getTenTL();
                        String anh = edt_anh.getText().toString();
                        String soluong = edt_soluong.getText().toString();
                        String gioithieu = edt_gioithieu.getText().toString();

                        if (edt_name.length() !=0 && edt_anh.length() !=0 && edt_price.length() !=0 && edt_gioithieu.length() !=0 && edt_soluong.length() != 0){
                            model_sanPham.setMaTL(index);
                            model_sanPham.setTenSP(name);
                            model_sanPham.setTenTL(theloai);
                            model_sanPham.setGiaTienSP(Integer.parseInt(price));
                            model_sanPham.setAnhSP(anh);
                            model_sanPham.setGioiThieuSP(gioithieu);
                            model_sanPham.setSoLuong(Integer.parseInt(soluong));

                            if (table_sanPham.insert(model_sanPham)){
                                list.clear();
                                list = table_sanPham.getAll();
                                recyclerView_dsSanpham = new RecyclerView_DSSanpham(DanhSachSanPham.this, list);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(DanhSachSanPham.this, RecyclerView.VERTICAL, false);
                                rcy_qlsanpham.setLayoutManager(layoutManager);
                                rcy_qlsanpham.setAdapter(recyclerView_dsSanpham);
                                dialog.dismiss();
                                Toast.makeText(DanhSachSanPham.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(DanhSachSanPham.this, "Thất bại", Toast.LENGTH_SHORT).show();

                            }
                        }else {
                            Toast.makeText(DanhSachSanPham.this, "Không đẻ ô nhập trống", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
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

    public void dialog_createSanPham(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        View v = View.inflate(this, R.layout.dialog_create_product, null);
//        builder.setView(v);
//        AlertDialog dialog = builder.create();
//
//        table_sanPham = new Table_SanPham(this);
//        table_theLoai = new Table_TheLoai(this);
//        model_theLoai = new Model_TheLoai();
//
//        spinner = v.findViewById(R.id.spinner);
//        edt_name = v.findViewById(R.id.edt_name);
//        edt_price = v.findViewById(R.id.edt_price);
//        edt_anh = v.findViewById(R.id.edt_anh);
//        edt_gioithieu = v.findViewById(R.id.edt_gioithieu);
//        btn_create = v.findViewById(R.id.btn_create);
//
//        List<Model_TheLoai> list = table_theLoai.getAll();
//
//        adapter_theLoai = new Adapter_TheLoai(list, this);
//        spinner.setAdapter(adapter_theLoai);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                index = i;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
//        btn_create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                model_sanPham = new Model_SanPham();
//                String name = edt_name.getText().toString();
//                String price = edt_price.getText().toString();
//                String theloai = list.get(index).getTenTL();
//                String anh = edt_anh.getText().toString();
//                String gioithieu = edt_gioithieu.getText().toString();
//
//                if (edt_name.length() !=0 && edt_anh.length() !=0 && edt_price.length() !=0 && edt_gioithieu.length() !=0 ){
//                    model_sanPham.setMaTL(index);
//                    model_sanPham.setTenSP(name);
//                    model_sanPham.setTenTL(theloai);
//                    model_sanPham.setGiaTienSP(Integer.parseInt(price));
//                    model_sanPham.setAnhSP(anh);
//                    model_sanPham.setGioiThieuSP(gioithieu);
//                    model_sanPham.setTonTai(1);
//                    if (table_sanPham.insert(model_sanPham)){
//
//                        dialog.dismiss();
//                        Toast.makeText(DanhSachSanPham.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(DanhSachSanPham.this, "Thất bại", Toast.LENGTH_SHORT).show();
//
//                    }
//                }else {
//                    Toast.makeText(DanhSachSanPham.this, "Không đẻ ô nhập trống", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        dialog.show();
    }
}