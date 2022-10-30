package com.jscreations.myloginapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2> {
    private final RecycleViewInterface recycleViewInterface;
    Context context;
    ArrayList<Address> list;

    public MyAdapter2(Context context, ArrayList<Address> list, RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.list = list;
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.addressentry,parent,false);
        return new MyViewHolder2(view,recycleViewInterface);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

        Address address = list.get(position);
        holder.addnm.setText(address.getAddressname());
        holder.addrs.setText(address.getAddresstext());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView addnm, addrs;
        public MyViewHolder2(@NonNull View itemView,RecycleViewInterface recycleViewInterface) {
            super(itemView);
            addnm = itemView.findViewById(R.id.textaddressname);
            addrs = itemView.findViewById(R.id.textaddress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleViewInterface!= null){
                        int pos = getAdapterPosition();
                        if(pos!= RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(pos);
                        }

                    }
                }
            });
        }
    }
}
