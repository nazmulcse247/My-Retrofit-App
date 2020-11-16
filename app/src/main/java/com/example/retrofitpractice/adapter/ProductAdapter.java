package com.example.retrofitpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.retrofitpractice.R;
import com.example.retrofitpractice.model.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Products> productsList;

    public ProductAdapter(Context context, List<Products> productsList){
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.product_row,parent,false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.titleTv.setText(productsList.get(position).getTitle());
        holder.albumIdTv.setText(String.valueOf(productsList.get(position).getAlbumId()));
        holder.idTv.setText(String.valueOf(productsList.get(position).getId()));

        Picasso.get().load(productsList.get(position).getUrl()).into(holder.productIv);

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView productIv;
        TextView titleTv,albumIdTv,idTv;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productIv = itemView.findViewById(R.id.iv_product);
            titleTv = itemView.findViewById(R.id.tv_title);
            albumIdTv = itemView.findViewById(R.id.tv_album_id);
            idTv = itemView.findViewById(R.id.tv_product_id);
        }
    }
}
