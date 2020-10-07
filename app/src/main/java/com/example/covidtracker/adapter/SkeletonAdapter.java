package com.example.covidtracker.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracker.R;

public class SkeletonAdapter extends RecyclerView.Adapter<SimpleRcvViewHolder> {


    @Override
    public SimpleRcvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleRcvViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.precaution_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SimpleRcvViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


}
