package com.example.covidtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covidtracker.R;
import com.example.covidtracker.model.Precautions;

import java.util.ArrayList;

public class PrecautionsAdapter extends RecyclerView.Adapter<PrecautionsAdapter.ViewHolder> {

    private ArrayList<Precautions> precautions;

    public PrecautionsAdapter(ArrayList<Precautions> precautions) {
        this.precautions = precautions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.precaution_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.precautionsImage)
                .asBitmap()
                .load(precautions.get(position).getImgResource())
                .into(holder.precautionsImage);

        holder.precautionsHeader.setText(precautions.get(position).getTitle());
        holder.precautionsBody.setText(precautions.get(position).getPrecautionsBody());

    }

    @Override
    public int getItemCount() {
        return precautions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView precautionsHeader=itemView.findViewById(R.id.precautions_header);
        TextView precautionsBody=itemView.findViewById(R.id.precautions_body);
        ImageView precautionsImage=itemView.findViewById(R.id.precautions_image);

    }

}
