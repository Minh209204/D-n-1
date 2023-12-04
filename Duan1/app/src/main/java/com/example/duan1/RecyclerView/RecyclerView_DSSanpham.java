package com.example.duan1.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.DataHelper.Adapter_TheLoai;
import com.example.duan1.Database.Table_SanPham;
import com.example.duan1.Database.Table_TheLoai;
import com.example.duan1.Model.Model_SanPham;
import com.example.duan1.Model.Model_TheLoai;
import com.example.duan1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerView_DSSanpham extends RecyclerView.Adapter<RecyclerView_DSSanpham.Holder_DSSanPham> {

    Context context;
    List<Model_SanPham> list;

    Table_SanPham table_sanPham;
    Adapter_TheLoai adapter_theLoai;
    Table_TheLoai table_theLoai;
    int index;

    public RecyclerView_DSSanpham(Context context, List<Model_SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_DSSanPham onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.rcy_danhsachsanpham, null);
        RecyclerView_DSSanpham.Holder_DSSanPham holder_dsSanPham = new Holder_DSSanPham(v);
        return holder_dsSanPham;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_DSSanPham holder, int position) {
        Model_SanPham model_sanPham = list.get(position);
        table_sanPham = new Table_SanPham(context);

        String img = model_sanPham.getAnhSP();

        Picasso.get().load(img).into(holder.img_create_product);
        holder.txt_create_name.setText(model_sanPham.getTenSP());
        holder.txt_create_price.setText(model_sanPham.getGiaTienSP() + "");


        holder.btn_create_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model_sanPham.getMaSP();
                model_sanPham.getMaTL();
                dialogEdit(model_sanPham);
            }
        });

        holder.btn_create_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model_sanPham.getMaSP();
                if (table_sanPham.delete(model_sanPham)){
                    list.clear();
                    list = table_sanPham.getAll();
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_DSSanPham extends RecyclerView.ViewHolder {
        ImageView img_create_product,btn_create_edit, btn_create_delete;
        TextView txt_create_name, txt_create_price;
        public Holder_DSSanPham(@NonNull View itemView) {
            super(itemView);
            img_create_product = itemView.findViewById(R.id.img_create_product);
            btn_create_edit = itemView.findViewById(R.id.btn_create_edit);
            btn_create_delete = itemView.findViewById(R.id.btn_create_delete);
            txt_create_name = itemView.findViewById(R.id.txt_create_name);
            txt_create_price = itemView.findViewById(R.id.txt_create_price);
        }
    }

    public void dialogEdit(Model_SanPham model_sanPham){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.dialog_dssanpham, null);
        builder.setView(v);
        AlertDialog dialog = builder.create();

        Spinner edit_spinner = v.findViewById(R.id.edit_spinner);
        EditText edt_edit_name = v.findViewById(R.id.edt_edit_name);
        EditText edt_edit_price = v.findViewById(R.id.edt_edit_price);
        EditText edt_edit_anh = v.findViewById(R.id.edt_edit_anh);
        EditText edt_edit_gioithieu = v.findViewById(R.id.edt_edit_gioithieu);
        Button btn_edit_create = v.findViewById(R.id.btn_edit_create);

        edt_edit_name.setText(model_sanPham.getTenSP());
        edt_edit_price.setText(model_sanPham.getGiaTienSP() + "");
        edt_edit_anh.setText(model_sanPham.getAnhSP());
        edt_edit_gioithieu.setText(model_sanPham.getGioiThieuSP());

        table_theLoai = new Table_TheLoai(context);
        List<Model_TheLoai> listTL = table_theLoai.getAll();

        adapter_theLoai = new Adapter_TheLoai(listTL, context);
        edit_spinner.setAdapter(adapter_theLoai);

        edit_spinner.setSelection(listTL.get(model_sanPham.getMaTL()).getMaTL());

        edit_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        btn_edit_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model_sanPham.getMaSP();
                String name = edt_edit_name.getText().toString();
                String price = edt_edit_price.getText().toString();
                String theloai = listTL.get(index).getTenTL();
                String anh = edt_edit_anh.getText().toString();
                String gioithieu = edt_edit_gioithieu.getText().toString();
//                String soluong = ed
//                model_sanPham.setSoLuong(Integer.parseInt(soluong));
                model_sanPham.setTenSP(name);
                model_sanPham.setTenTL(theloai);
                model_sanPham.setMaTL(index);
                model_sanPham.setGiaTienSP(Integer.parseInt(price));
                model_sanPham.setAnhSP(anh);
                model_sanPham.setGioiThieuSP(gioithieu);
                model_sanPham.setSoLuong(10);

                if (table_sanPham.update(model_sanPham)){
                    Toast.makeText(context, "Sửa thông tin thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(context, "Sửa thông tin Thất bại", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
