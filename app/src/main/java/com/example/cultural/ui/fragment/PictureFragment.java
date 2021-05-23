package com.example.cultural.ui.fragment;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;
import com.example.cultural.base.BaseFragment;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.presenter.IPicturePresenter;
import com.example.cultural.presenter.impl.PicturePresenterImpl;
import com.example.cultural.ui.adapter.PictureListAdapter;
import com.example.cultural.utils.ItemDecoration;
import com.example.cultural.view.IPictureCallback;

import java.util.List;

import butterknife.BindView;

public class PictureFragment extends BaseFragment implements IPictureCallback {

    @BindView(R.id.recyclerview_picture)
    public RecyclerView mRecyclerView;
    private PictureListAdapter mPictureListAdapter;
    private IPicturePresenter mPicturePresenter;

    @Override
    protected int getRootViewResId() {
        Log.d("picture","test");
        return R.layout.fragment_picture;
    }

    @Override
    protected void initPresenter() {
        mPicturePresenter = new PicturePresenterImpl();
        mPicturePresenter.registerViewCallback(this);
    }

    @Override
    protected void loadData() {
        mPicturePresenter.getPictures();
    }

    @Override
    protected void initView(View rootView) {
        Log.d("pic","test");
       mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
       //mRecyclerView.addItemDecoration(new ItemDecoration(20));
     // mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
      mPictureListAdapter = new PictureListAdapter();
      mRecyclerView.setAdapter(mPictureListAdapter);
    }

    @Override
    public void onPictureLoad(List<PictureResponse> pictureResponseList) {
        //TODO:recyclerview Setdata
        setupState(State.SUCCESS);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }
}
