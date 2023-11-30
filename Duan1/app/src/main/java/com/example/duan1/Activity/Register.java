package com.example.duan1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {
    TextInputLayout error_register_name, error_register_account, error_register_password, error_register_sdt;
    TextInputEditText edt_register_name, edt_register_account, edt_register_password, edt_register_sdt;
    Button btn_Register;
    Table_KhachHang table_khachHang;
//    Model_KhachHang model_khachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        table_khachHang = new Table_KhachHang(this);

        error_register_name = findViewById(R.id.error_register_name);
        error_register_account = findViewById(R.id.error_register_account);
        error_register_password = findViewById(R.id.error_register_password);
        error_register_sdt = findViewById(R.id.error_register_sdt);
        edt_register_name = findViewById(R.id.edt_register_name);
        edt_register_account = findViewById(R.id.edt_register_account);
        edt_register_password = findViewById(R.id.edt_register_password);
        edt_register_sdt = findViewById(R.id.edt_register_sdt);
        btn_Register = findViewById(R.id.btn_Register);

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model_KhachHang model_khachHang = new Model_KhachHang();

                String name = edt_register_name.getText().toString();
                String account = edt_register_account.getText().toString();
                String password = edt_register_password.getText().toString();
                String sdt = edt_register_sdt.getText().toString();

                model_khachHang.setTenKH(name);
                model_khachHang.setTaiKhoan(account);
                model_khachHang.setMatKhau(password);
                model_khachHang.setSDTKH(sdt);

                if (edt_register_name.length() == 0){
                    error_register_name.setError("Không để trống ô nhập");
                }else {
                    error_register_name.setError("");
                }

                if (edt_register_account.length() == 0){
                    error_register_account.setError("Không để trống ô nhập");
                }else {
                    error_register_account.setError("");
                }

                if (edt_register_password.length() == 0){
                    error_register_password.setError("Không để trống ô nhập");
                }else {
                    error_register_password.setError("");
                }

                if (edt_register_sdt.length() == 0){
                    error_register_sdt.setError("Không để trống ô nhập");
                }else {
                    error_register_sdt.setError("");
                }

                if (table_khachHang.insert(model_khachHang) && edt_register_name.length() != 0 && edt_register_account.length() != 0 && edt_register_password.length() != 0 && edt_register_sdt.length() != 0){
                    startActivity(new Intent(Register.this, Login.class));
                }else{
                    Log.d("TAG", "onClick: " + table_khachHang.insert(model_khachHang) + "");
                    Toast.makeText(Register.this, "Vui lòng đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}