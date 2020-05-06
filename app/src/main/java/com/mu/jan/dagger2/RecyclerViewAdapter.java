package com.mu.jan.dagger2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import javax.inject.Inject;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
   private Context context;
    public RecyclerViewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(context);
       View v =  inflater.inflate(R.layout.adapter_layout,parent,false);
       return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.tony));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_1);
        }
    }
}
