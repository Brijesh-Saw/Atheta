package com.brijesh.athetaassignmaent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    ArrayList<UserModel> dataList;
    Context mContext;

    public Adapter(ArrayList<UserModel> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.FullName.setText(dataList.get(position).getFirst());
//        notifyDataSetChanged();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,userActivity.class);
                intent.putExtra("fname",dataList.get(position).getFirst());
                intent.putExtra("lname",dataList.get(position).getLast());
                intent.putExtra("phone",dataList.get(position).getPhone());
                intent.putExtra("add",dataList.get(position).getAdd());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView FullName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            FullName = itemView.findViewById(R.id.name_user);
        }
    }
}
