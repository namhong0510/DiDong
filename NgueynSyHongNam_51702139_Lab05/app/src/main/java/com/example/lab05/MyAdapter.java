package com.example.lab05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Data> datas;

    public MyAdapter(Context context, List<Data> datas){
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View root = inflater.inflate(R.layout.advance_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(root);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data data = datas.get(position);
        holder.appName.setText(data.appName);
        holder.sizeText.setText(data.size);
        holder.dateText.setText(data.date);

        int ImageId = R.drawable.mobile3;
        if(data.id%2==0){
            ImageId = R.drawable.mobile1;
        } else {
            ImageId = R.drawable.mobile2;
        }

        holder.imageView.setImageResource(ImageId);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView appName, sizeText, dateText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            appName = itemView.findViewById(R.id.appName);
            sizeText = itemView.findViewById(R.id.sizeText);
            dateText = itemView.findViewById(R.id.dateText);
        }
    }
}
