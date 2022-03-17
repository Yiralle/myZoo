package com.example.zooapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data[];
    String data2[];
    int images [];
    Context context;

    public MyAdapter(Context ct, String aTitle[], String aInfo[], int img[]){
        context = ct;
        data = aTitle;
        data2 = aInfo;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout. row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.textview.setText(data[position]);
    holder.imageview.setImageResource(images[position]);

    holder.mainLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent (context, DetailActivity.class);
            intent.putExtra("data", data[position]);
            intent.putExtra("data2", data2[position]);
            intent.putExtra ("image", images[position]);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textview;
        ImageView imageview;
        TextView animalDetail;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.textView2);
            imageview = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
