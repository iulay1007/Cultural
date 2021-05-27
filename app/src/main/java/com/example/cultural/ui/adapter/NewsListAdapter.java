package com.example.cultural.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.InnerHolder> {


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);

        return new NewsListAdapter.InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  NewsListAdapter.InnerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        //TODO
        return 10;
    }

    public class InnerHolder extends RecyclerView.ViewHolder{
        public InnerHolder(@NonNull  View itemView) {
            super(itemView);
        }
    }
}
