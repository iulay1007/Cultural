package com.example.cultural.ui.adapter;

import android.app.backup.BackupDataInput;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cultural.R;
import com.example.cultural.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowPictureListAdapter extends RecyclerView.Adapter<ShowPictureListAdapter.InnerHolder> {
    private List<String> mPictureList =new ArrayList<>();
    private List<String> mTitleList =new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show_picture,parent,false);

        return new ShowPictureListAdapter.InnerHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull  ShowPictureListAdapter.InnerHolder holder, int position) {
        holder.setData(mPictureList.get(position),mTitleList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mPictureList != null) {
            return mPictureList.size();
        }
        else return 10;
    }

    public void setData(List<String> mPictureList,List<String> mTitleList){
        this.mPictureList = mPictureList;
        this.mTitleList = mTitleList ;
    }

    public class InnerHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_iv)
        ImageView imageView;
        @BindView(R.id.title_tv)
        TextView textView;

        public InnerHolder(@NonNull  View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
        public void setData(String pic_url,String title){
            Glide.with(itemView.getContext()).load(Constants.BASE_URL+pic_url).into(this.imageView);
            textView.setText(title);


        }
    }
}
