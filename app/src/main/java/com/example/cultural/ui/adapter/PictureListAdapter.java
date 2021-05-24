package com.example.cultural.ui.adapter;

import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cultural.R;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.utils.Constants;
import com.example.cultural.utils.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureListAdapter extends RecyclerView.Adapter<PictureListAdapter.InnerHolder> {

    private List<PictureResponse> mData=new ArrayList<>();

    public void setOnPictureItemClickListener(PictureListAdapter.onPictureItemClickListener onPictureItemClickListener) {
        this.onPictureItemClickListener = onPictureItemClickListener;
    }

    private onPictureItemClickListener onPictureItemClickListener= null;
    //TODO:Listdata
    @Override
    public PictureListAdapter.InnerHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture,parent,false);

        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  PictureListAdapter.InnerHolder holder, int position) {
    PictureResponse bean = mData.get(position);
    holder.setData(bean);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (onPictureItemClickListener != null) {
                onPictureItemClickListener.onItemClick(bean);
            }
        }
    });
    }

    public interface onPictureItemClickListener{
        void onItemClick(PictureResponse item);
    }

    @Override
    public int getItemCount() {
        if (mData!=null)
        return mData.size();
        else return 10;
    }

    public void setmData(List<PictureResponse> list) {
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }


    public static class InnerHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image_iv)
        ImageView image_iv;
        @BindView(R.id.picture_title_tv)
        TextView title_tv;
        @BindView(R.id.picture_date_tv)
        TextView date_tv;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(PictureResponse bean){
            System.out.println(Constants.BASE_URL+bean.getUrl());
            Glide.with(itemView.getContext()).load(Constants.BASE_URL+bean.getUrl()).into(this.image_iv);
            title_tv.setText(bean.getTitle());
            date_tv.setText(bean.getDate());

        }


    }


}
