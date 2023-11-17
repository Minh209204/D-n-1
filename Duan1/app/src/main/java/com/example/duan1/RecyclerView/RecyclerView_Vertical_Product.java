//package com.example.duan1.RecyclerView;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.duan1.Model.Product;
//import com.example.duan1.R;
//
//import java.util.List;
//
//public class RecyclerView_Vertical_Product extends RecyclerView.Adapter<RecyclerView_Vertical_Product.Holder_Vertical>{
//    private Context context;
//    private List<Product> list;
//    Product product;
//    public RecyclerView_Vertical_Product(Context context, List<Product> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public Holder_Vertical onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View v = inflater.inflate(R.layout.layout_vertical_product, null);
//
//        RecyclerView_Vertical_Product.Holder_Vertical holder = new Holder_Vertical(v);
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Holder_Vertical holder, int position) {
//        product = list.get(position);
//
//        holder.img_Vertical.setImageResource(product.getImg());
//        holder.txt_Vertical_name.setText(product.getName());
//        holder.txt_Vertical_price.setText(product.getPrice() + "");
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class Holder_Vertical extends RecyclerView.ViewHolder {
//        ImageView img_Vertical;
//        TextView txt_Vertical_name, txt_Vertical_price;
//
//        public Holder_Vertical(@NonNull View itemView) {
//            super(itemView);
//            img_Vertical = itemView.findViewById(R.id.img_Vertical);
//            txt_Vertical_name = itemView.findViewById(R.id.txt_Vertical_name);
//            txt_Vertical_price = itemView.findViewById(R.id.txt_Vertical_price);
//        }
//    }
//
//}
