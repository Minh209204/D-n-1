package com.example.duan1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.duan1.R;

public class ThongTinCaNhan extends AppCompatActivity {
    Toolbar toolbar;
    TextView txt_name, txt_account, txt_password, txt_sdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);

        toolbar = findViewById(R.id.toolbar);
        txt_name = findViewById(R.id.txt_name);
        txt_account = findViewById(R.id.txt_account);
        txt_password = findViewById(R.id.txt_password);
        txt_sdt = findViewById(R.id.txt_sdt);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thông tin cá nhân");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}