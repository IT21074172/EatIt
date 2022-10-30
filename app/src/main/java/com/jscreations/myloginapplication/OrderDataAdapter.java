package com.jscreations.myloginapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderDataAdapter extends RecyclerView.Adapter<OrderDataAdapter.MyViewHolder> {
    private final OrderInterface recyclerViewInterface;
    Context context;
    ArrayList<OrderModel> OrderList ;

    public OrderDataAdapter(Context context, ArrayList<OrderModel> orderList,OrderInterface recyclerViewInterface) {
        this.context = context;
        OrderList = orderList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public OrderDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.order_item,parent,false);
        return new MyViewHolder(v,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDataAdapter.MyViewHolder holder, int position) {
        OrderModel order = OrderList.get(position);

        holder.orderName.setText(order.getOrderName());
        holder.riderName.setText(order.getRiderName());
        holder.instructions.setText(order.getSpecialInstructions());

    }

    @Override
    public int getItemCount() {
        return OrderList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView orderName ,riderName,instructions;

        public MyViewHolder(@NonNull View itemView,OrderInterface recyclerViewInterface) {
            super(itemView);
            orderName = itemView.findViewById(R.id.txtOrderName);
            riderName = itemView.findViewById(R.id.txtRiderName);
            instructions = itemView.findViewById(R.id.txtInstructions);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position = getBindingAdapterPosition();

                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public static class viewHolderForItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        public viewHolderForItem(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {
        }
    }
}
