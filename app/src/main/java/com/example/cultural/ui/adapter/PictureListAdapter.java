package com.example.cultural.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;

public class PictureListAdapter extends RecyclerView.Adapter<PictureListAdapter.InnerHolder> {

    //TODO:Listdata
    @Override
    public PictureListAdapter.InnerHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture,parent,false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  PictureListAdapter.InnerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class InnerHolder extends RecyclerView.ViewHolder{
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
