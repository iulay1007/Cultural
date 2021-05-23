package com.example.cultural.ui.adapter;

import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;
import com.example.cultural.utils.ScreenSizeUtils;

public class PictureListAdapter extends RecyclerView.Adapter<PictureListAdapter.InnerHolder> {

    //TODO:Listdata
    @Override
    public PictureListAdapter.InnerHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture,parent,false);
        Point point= ScreenSizeUtils.getScreenSize(itemView.getContext());
      // RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams((int) (point.x/2.5), (int) (0.60*point.x));
        //itemView.setLayoutParams(layoutParams);
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
