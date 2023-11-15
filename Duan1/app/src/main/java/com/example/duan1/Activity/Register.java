package com.example.duan1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.duan1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {
    TextInputLayout error_register_account, error_register_password, error_register_sdt;
    TextInputEditText edt_register_account, edt_register_password, edt_register_sdt;
    Button btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        error_register_account = findViewById(R.id.error_register_account);
        error_register_password = findViewById(R.id.error_register_password);
        error_register_sdt = findViewById(R.id.error_register_sdt);
        edt_register_account = findViewById(R.id.edt_register_account);
        edt_register_password = findViewById(R.id.edt_register_password);
        edt_register_sdt = findViewById(R.id.edt_register_sdt);
        btn_Register = findViewById(R.id.btn_Register);

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                if (edt_register_sdt.length() != 0 && edt_register_password.length() != 0 && edt_register_account.length() != 0){
                    startActivity(new Intent(Register.this, Login.class));
                }
            }
        });

    }
}