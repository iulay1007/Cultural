package com.example.cultural.ui.fragment;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;
import com.example.cultural.base.BaseFragment;
import com.example.cultural.ui.adapter.PictureListAdapter;

import butterknife.BindView;

public class PictureFragment extends BaseFragment {

    @BindView(R.id.recyclerview_picture)
    public RecyclerView mRecyclerView;
    private PictureListAdapter mPictureListAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_picture;
    }


    @Override
    protected void initView(View rootView) {
      //  mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPictureListAdapter = new PictureListAdapter();
        mRecyclerView.setAdapter(mPictureListAdapter);
    }
}
