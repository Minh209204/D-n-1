package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.duan1.Database.Table_TaiKhoan;
import com.example.duan1.Model.TaiKhoan;
import com.example.duan1.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Register extends AppCompatActivity {
    TextInputLayout error_register_account, error_register_password, error_register_sdt;
    TextInputEditText edt_register_account, edt_register_password, edt_register_sdt;
    Button btn_Register;
    Table_TaiKhoan table_taiKhoan;
    TaiKhoan taiKhoan;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseFirestore = FirebaseFirestore.getInstance();
        table_taiKhoan = new Table_TaiKhoan(this);

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

                String account = edt_register_account.getText().toString();
                String password = edt_register_password.getText().toString();
                String sdt = edt_register_sdt.getText().toString();

                taiKhoan = new TaiKhoan(Integer.parseInt(sdt), account, password);

                HashMap<String, Object> hashMap = taiKhoan.canvert();

                firebaseFirestore.collection(String.valueOf(taiKhoan)).document(sdt)
                        .set(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Register.this, "them thanh cong", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register.this, "that bai", Toast.LENGTH_SHORT).show();
                            }
                        });



//                taiKhoan.setTaiKhoan(account);
//                taiKhoan.setMatKhau(password);
//                taiKhoan.setSDT(Integer.parseInt(sdt));

//                if (table_taiKhoan.insert(taiKhoan) == true){
//                    startActivity(new Intent(Register.this, Login.class));
//                }else{
//                    Toast.makeText(Register.this, "sai roi", Toast.LENGTH_SHORT).show();
//                }
//
//                if (edt_register_account.length() == 0){
//                    error_register_account.setError("Không để trống ô nhập");
//                }else {
//                    error_register_account.setError("");
//                }
//
//                if (edt_register_password.length() == 0){
//                    error_register_password.setError("Không để trống ô nhập");
//                }else {
//                    error_register_password.setError("");
//                }
//
//                if (edt_register_sdt.length() == 0){
//                    error_register_sdt.setError("Không để trống ô nhập");
//                }else {
//                    error_register_sdt.setError("");
//                }
//
//                if (edt_register_sdt.length() != 0 && edt_register_password.length() != 0 && edt_register_account.length() != 0){
//                    startActivity(new Intent(Register.this, Login.class));
//                }
            }
        });

    }


}