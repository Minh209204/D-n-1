package com.example.duan1.RecyclerView;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Database.Table_GioHang;
import com.example.duan1.Database.Table_KhachHang;
import com.example.duan1.EventBus.Event_TongTien_Cart;
import com.example.duan1.Model.Model_GioHang;
import com.example.duan1.Model.Model_KhachHang;
import com.example.duan1.R;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class RecyclerView_Cart extends RecyclerView.Adapter<RecyclerView_Cart.Holder_Cart>{
    private Context context;
    private List<Model_GioHang> list;
    Table_KhachHang table_khachHang;
    private Table_GioHang table_gioHang;
    public RecyclerView_Cart(Context context, List<Model_GioHang> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder_Cart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.layout_giohang_product, null);

        RecyclerView_Cart.Holder_Cart holder_cart = new Holder_Cart(v);
        return holder_cart;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Cart holder, int position) {
        Model_GioHang model_gioHang = list.get(position);
        Model_KhachHang model_khachHang = new Model_KhachHang();
        table_gioHang = new Table_GioHang(context);
        table_khachHang = new Table_KhachHang(context);

        //set du lieu
        Picasso.get().load(model_gioHang.getAnhSP()).into(holder.img_cart);
        holder.txt_cart_name.setText(model_gioHang.getTenSP());
        holder.txt_cart_price.setText(String.valueOf(model_gioHang.getGiaSP()));
        holder.txt_quantity_cart.setText(model_gioHang.getSoLuongSP()+"");
        if (model_gioHang.getCheckBox() == 1){
            holder.cbox_cart.setChecked(true);
        }else {
            holder.cbox_cart.setChecked(false);
        }
        if (model_gioHang.getSoLuongSP() == 0){
            holder.txt_quantity_cart.setText("1");
        }

        //xu li su kien
        holder.cbox_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model_gioHang.getMaGH();

                if (holder.cbox_cart.isChecked()){
                    model_gioHang.setCheckBox(1);
                    table_gioHang.update(model_gioHang);
                    notifyDataSetChanged();
                    EventBus.getDefault().post(new Event_TongTien_Cart());
                }else {
                    model_gioHang.setCheckBox(0);
                    table_gioHang.update(model_gioHang);
                    notifyDataSetChanged();
                    EventBus.getDefault().post(new Event_TongTien_Cart());
                }
            }
        });
        //xao san pham
        holder.btn_delete_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("account", Context.MODE_PRIVATE);
                String taikhoan = sharedPreferences.getString("taikhoan", "");
                String matkhau = sharedPreferences.getString("matkhau", "");
                model_khachHang.setTaiKhoan(taikhoan);
                model_khachHang.setMatKhau(matkhau);

                List<Model_KhachHang> listKH = table_khachHang.checkKhachHang(model_khachHang);
                model_khachHang.setMaKH(listKH.get(0).getMaKH());

                model_gioHang.getMaGH();
                table_gioHang.delete(model_gioHang);
                list.clear();
                list = table_gioHang.getAll(model_khachHang);
                notifyDataSetChanged();
                EventBus.getDefault().post(new Event_TongTien_Cart());
            }
        });
        //tang so luong
        holder.btn_total_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = model_gioHang.getSoLuongSP();
                holder.txt_quantity_cart.setText(++quantity + "");
                model_gioHang.setSoLuongSP(quantity);
                table_gioHang.update(model_gioHang);
                notifyDataSetChanged();
                EventBus.getDefault().post(new Event_TongTien_Cart());
            }
        });
        //giam so luong
        holder.btn_reduce_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = model_gioHang.getSoLuongSP();

                if (quantity > 1){
                    quantity-= 1;
                    holder.txt_quantity_cart.setText(quantity + "");
                    model_gioHang.setSoLuongSP(quantity);
                    table_gioHang.update(model_gioHang);
                    notifyDataSetChanged();
                    EventBus.getDefault().post(new Event_TongTien_Cart());
                } else if (quantity <= 0) {
                    quantity = 0;
                    holder.txt_quantity_cart.setText(quantity + "");
                    model_gioHang.setSoLuongSP(quantity);
                    table_gioHang.update(model_gioHang);
                    EventBus.getDefault().post(new Event_TongTien_Cart());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_Cart extends RecyclerView.ViewHolder {
        CheckBox cbox_cart;
        ImageView img_cart;
        TextView txt_cart_name, txt_cart_price, txt_quantity_cart;
        ImageButton btn_total_cart, btn_reduce_cart, btn_delete_cart;


        public Holder_Cart(@NonNull View itemView) {
            super(itemView);
            cbox_cart = itemView.findViewById(R.id.cbox_cart);
            img_cart = itemView.findViewById(R.id.img_cart);
            txt_cart_name = itemView.findViewById(R.id.txt_cart_name);
            txt_cart_price = itemView.findViewById(R.id.txt_cart_price);
            txt_quantity_cart = itemView.findViewById(R.id.txt_quantity_cart);
            btn_total_cart = itemView.findViewById(R.id.btn_total_cart);
            btn_reduce_cart = itemView.findViewById(R.id.btn_reduce_cart);
            btn_delete_cart = itemView.findViewById(R.id.btn_delete_cart);
        }
    }
}
