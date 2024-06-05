package com.example.cafepda;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OpenOrdersAdapter extends RecyclerView.Adapter<OpenOrdersAdapter.ViewHolder>{

    private ArrayList<Order> openOrders;
    private int[] colors;
    private final OpenOrdersAdapter.OnAddButtonClickListener listener;
    public OpenOrdersAdapter(ArrayList<Order> openOrders, OnAddButtonClickListener listener) {
        this.openOrders = openOrders;
        this.listener = listener;
        this.colors=new int[]{
                Color.parseColor("#FFA5CDCA"),
                Color.parseColor("#FF96C3BF"),
                Color.parseColor("#FF72A5A1"),
                Color.parseColor("#FF578885"),
                Color.parseColor("#FF467A76"),
                Color.parseColor("#FF38716D"),
        };
    }

    public interface OnAddButtonClickListener {
        void onAddButtonClicked(Order order);
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
        Order order = openOrders.get(position);
        holder.payButton.setOnClickListener(v -> {
            listener.onAddButtonClicked(order);
        });
        holder.cardlayout.setBackgroundColor(colors[position]);

    }

    @Override
    public int getItemCount() {
        return openOrders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        Button payButton;

        ConstraintLayout cardlayout;
        TextView orderTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            payButton = itemView.findViewById(R.id.payButton);
            orderTextView = itemView.findViewById(R.id.showOrderTextView);
            cardlayout=itemView.findViewById(R.id.card_layout);
        }
    }
}
