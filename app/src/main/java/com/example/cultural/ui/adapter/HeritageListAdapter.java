package com.example.cultural.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cultural.R;
import com.example.cultural.model.domain.HeritageResponse;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeritageListAdapter extends RecyclerView.Adapter<HeritageListAdapter.InnerHolder> {




    List<HeritageResponse> mdata = new ArrayList<>();

    public void setOnHeritageItemClickListener(HeritageListAdapter.onHeritageItemClickListener onHeritageItemClickListener) {
        this.onHeritageItemClickListener = onHeritageItemClickListener;
    }

    private onHeritageItemClickListener onHeritageItemClickListener = null;


        @NonNull
        @Override
        public HeritageListAdapter.InnerHolder onCreateViewHolder (@NonNull ViewGroup parent,
        int viewType){
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heritage,parent,false);

            return new HeritageListAdapter.InnerHolder(itemView);
    }

        @Override
        public void onBindViewHolder (@NonNull HeritageListAdapter.InnerHolder holder,int position){
            HeritageResponse bean = mdata.get(position);
            holder.setData(bean);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onHeritageItemClickListener != null) {
                        if (bean!=null) {
                            onHeritageItemClickListener.onItemClick(bean);

                        }
                    }

                }
            });
    }

        @Override
        public int getItemCount () {
        if(mdata!=null)
          return mdata.size();
        else return 10;

    }

    public void setmdata(List<HeritageResponse> mdata) {
        this.mdata.clear();
        this.mdata.addAll(mdata);
        notifyDataSetChanged();
    }

    public interface onHeritageItemClickListener{
        void onItemClick(HeritageResponse item);
    }


    public static class InnerHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.heritage_title_tv)
        TextView heritage_title_tv;
        @BindView(R.id.heritage_province_tv)
        TextView heritage_province_tv;
        @BindView(R.id.heritage_type_tv)
        TextView heritage_type_tv;
        public InnerHolder(@NonNull  View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
        public void setData(HeritageResponse bean){
            heritage_title_tv.setText(bean.getTitle());
            heritage_province_tv.setText(bean.getProvince());
            heritage_type_tv.setText(bean.getMtype());
        }
    }
}