package com.jscreations.myloginapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Item>list1;

    public MyAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list1 = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itementry,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = list1.get(position);
        holder.name.setText(item.getItemname());
        holder.price.setText(item.getPrice());
        holder.desc.setText(item.getDescription());


    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,price,desc;
        ImageView delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textname);
            price = itemView.findViewById(R.id.textprice);
            desc = itemView.findViewById(R.id.textdesc);
        }
    }
}
