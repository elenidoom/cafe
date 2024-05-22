package com.example.cafepda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private final String[] titles = {"coffee", "tea", "water", "cola", "fanta",
            "beer", "wine", "potatoes"};
    private final String[] prices = {"2.5","2","0.5","2.2","2","3","4","4.5"};

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.ProductTitle.setText(titles[position]);
        holder.PriceText.setText(prices[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ProductImage;
        TextView ProductTitle;
        TextView PriceText;
        TextView QuantityText;
        Button ButtonPlus;
        Button ButtonMinus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ProductImage = itemView.findViewById(R.id.product_image);
            ProductTitle = itemView.findViewById(R.id.product_title);
            PriceText = itemView.findViewById(R.id.price_text);
            QuantityText = itemView.findViewById(R.id.quantity_text);
            ButtonPlus = itemView.findViewById(R.id.button_plus);
            ButtonMinus = itemView.findViewById(R.id.button_minus);
        }
    }
}
