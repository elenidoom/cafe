package com.example.cafepda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OpenOrdersAdapter extends RecyclerView.Adapter<OpenOrdersAdapter.ViewHolder>{

    private ArrayList<Order> openOrders;
    public OpenOrdersAdapter(ArrayList<Order> openOrders) {
        this.openOrders = openOrders;
    }

    @NonNull
    @Override
    public OpenOrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.open_order_card,parent,false);
        return new OpenOrdersAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OpenOrdersAdapter.ViewHolder holder, int position) {
        holder.orderTextView.setText(openOrders.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return openOrders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        Button payButton;
        TextView orderTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            payButton = itemView.findViewById(R.id.payButton);
            orderTextView = itemView.findViewById(R.id.showOrdertextView);
        }
    }
}
