package com.example.trackyourscrolls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Zone_Adapter extends RecyclerView.Adapter<Zone_Adapter.MyViewHolder> {
    Context context;
    ArrayList<ZoneModel> zoneModels;

    public Zone_Adapter(Context context, ArrayList<ZoneModel> zonemodel){
        this.context = context;
        this.zoneModels = zonemodel;

    }
    @NonNull
    @Override
    public Zone_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_zone_row,parent,false);

        return new Zone_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Zone_Adapter.MyViewHolder holder, int position) {
        holder.blockText.setText(zoneModels.get(position).getBlockText());

    }

    @Override
    public int getItemCount() {
        return zoneModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView blockText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            blockText = itemView.findViewById(R.id.tvModelBlock);
        }
    }
}
