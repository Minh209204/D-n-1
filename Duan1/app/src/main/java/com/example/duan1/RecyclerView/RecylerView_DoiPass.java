package com.example.duan1.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.Fragment.Fragment_ThongTin;
import com.example.duan1.R;

public class RecylerView_DoiPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view_doi_pass);
        findViewById(R.id.thoat).setOnClickListener(v -> {
            Intent intent = new Intent(RecylerView_DoiPass.this, Fragment_ThongTin.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(RecylerView_DoiPass.this).toBundle();
            startActivity(intent, bundle);
        });
    }
}