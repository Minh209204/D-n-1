package com.example.duan1.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Model.Model_GioHang;
import com.example.duan1.Model.Model_TheLoai;
import com.example.duan1.R;

import java.util.List;

public class RecyclerView_ThongBao extends RecyclerView.Adapter<RecyclerView_ThongBao.Holder_ThongBao> {
    Context context;
    List<Model_GioHang> list;

    public RecyclerView_ThongBao(Context context, List<Model_GioHang> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_ThongBao onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.rcy_thongbao, null);

        RecyclerView_ThongBao.Holder_ThongBao holderThongBao = new Holder_ThongBao(v);
        return holderThongBao;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_ThongBao holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_ThongBao extends RecyclerView.ViewHolder {
        public Holder_ThongBao(@NonNull View itemView) {
            super(itemView);
        }
    }
}
