package com.example.duan1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    TextInputLayout error_login_account, error_login_password;
    TextInputEditText edt_login_account, edt_login_password;
    CheckBox cbox_remember;
    Button btn_SignUp;
    ImageButton btn_img_facebook, btn_img_google, btn_img_gmail;
    TextView txt_createAccount;
    Model_KhachHang khoan;
    Table_KhachHang table_khachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        table_khachHang = new Table_KhachHang(this);
        khoan = new Model_KhachHang();

        error_login_account = findViewById(R.id.error_login_account);
        error_login_password = findViewById(R.id.error_login_password);
        edt_login_account = findViewById(R.id.edt_login_account);
        edt_login_password = findViewById(R.id.edt_login_password);
        cbox_remember = findViewById(R.id.cbox_remember);
        btn_SignUp = findViewById(R.id.btn_SignUp);
        btn_img_facebook = findViewById(R.id.btn_img_facebook);
        btn_img_google = findViewById(R.id.btn_img_google);
        btn_img_gmail = findViewById(R.id.btn_img_gmail);
        txt_createAccount = findViewById(R.id.txt_createAccount);

        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = edt_login_account.getText().toString();
                String matkhau = edt_login_password.getText().toString();

                khoan.setTaiKhoan(taikhoan);
                khoan.setMatKhau(matkhau);
//                check account
                if (edt_login_account.length() == 0){
                    error_login_account.setError("Không để trống ô nhập");
                }else {
                    error_login_account.setError("");
                }

//                check pass
                if (edt_login_password.length() == 0){
                    error_login_password.setError("Không để trống ô nhập");
                }else if (table_khachHang.checkAccount(khoan) == false){
                    error_login_password.setError("Sai mật khẩu");
                }else {
                    error_login_password.setError("");
                }

                if (cbox_remember.isChecked()){
                    Toast.makeText(Login.this, "Đã lưu đăng nhập", Toast.LENGTH_SHORT).show();
                }

                if (table_khachHang.checkAccount(khoan)){
                    SharedPreferences sharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if (editor != null){
                        editor.clear();
                        editor.putString("taikhoan", taikhoan);
                        editor.putString("matkhau", matkhau);
                        editor.apply();
                    }else {
                        editor.clear();
                        editor.putString("taikhoan", taikhoan);
                        editor.putString("matkhau", matkhau);
                        editor.apply();
                    }
                    startActivity(new Intent(Login.this, Main.class));
                }
            }
        });

        txt_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });


    }
}