package com.example.duan1.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ActivityOptions;

import com.example.duan1.Activity.Login;
import com.example.duan1.R;
import com.example.duan1.RecyclerView.RecylerView_DoiPass;
import com.example.duan1.RecyclerView.RecylerView_LayLaiMK;
import com.example.duan1.RecyclerView.RecylerView_ThongTinKh;
import com.example.duan1.RecyclerView.RecylerView_YeuThich;
//import com.google.firebase.auth.FirebaseAuth;

public class Fragment_ThongTin extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_thongtin, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.ln_thongtinkh).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RecylerView_ThongTinKh.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
            startActivity(intent, bundle);
        });
        view.findViewById(R.id.ln_yeuthich).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RecylerView_YeuThich.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
            startActivity(intent, bundle);
        });
        view.findViewById(R.id.ln_laylaimatkhau).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RecylerView_LayLaiMK.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
            startActivity(intent, bundle);
        });
        view.findViewById(R.id.ln_doipass).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RecylerView_DoiPass.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
            startActivity(intent, bundle);
        });
        view.findViewById(R.id.tv_logout).setOnClickListener(v -> {
            // Hiển thị hộp thoại thông báo
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Bạn có muốn đăng xuất không?")
                    .setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Người dùng đã chọn đăng xuất
//                            FirebaseAuth.getInstance().signOut();
                            Intent intent = new Intent(getActivity(), Login.class);
                            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
                            startActivity(intent, bundle);
                        }
                    })
                    .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Người dùng đã chọn hủy
                            dialog.dismiss();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
}