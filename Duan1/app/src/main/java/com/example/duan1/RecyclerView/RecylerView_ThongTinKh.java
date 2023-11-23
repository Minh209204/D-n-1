package com.example.duan1.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.Fragment.Fragment_ThongTin;
import com.example.duan1.R;

public class RecylerView_ThongTinKh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view_thong_tin_kh);

        findViewById(R.id.thoat).setOnClickListener(v -> {
            Intent intent = new Intent(RecylerView_ThongTinKh.this, Fragment_ThongTin.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(RecylerView_ThongTinKh.this).toBundle();
            startActivity(intent, bundle);
        });
    }
}