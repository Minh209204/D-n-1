package com.example.duan1.DataHelper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1.Model.Model_TheLoai;
import com.example.duan1.R;

import java.util.List;

public class Adapter_TheLoai extends BaseAdapter {

    List<Model_TheLoai> list;
    Context context;
    Model_TheLoai model_theLoai;

    public Adapter_TheLoai(List<Model_TheLoai> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        view = inflater.inflate(R.layout.layout_spinner_product, null);

        model_theLoai = new Model_TheLoai();

        TextView txtTheLoai = view.findViewById(R.id.txtTheLoai);

        txtTheLoai.setText(list.get(i).getTenTL());
        return view;
    }
}
