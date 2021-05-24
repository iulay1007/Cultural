package com.example.cultural.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Message;
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
import com.example.cultural.ui.activity.ShowPictureActivity;
import com.example.cultural.ui.adapter.PictureListAdapter;
import com.example.cultural.utils.ItemDecoration;
import com.example.cultural.view.IPictureCallback;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

import butterknife.BindView;

public class PictureFragment extends BaseFragment implements IPictureCallback, PictureListAdapter.onPictureItemClickListener {

    @BindView(R.id.recyclerview_picture)
    public RecyclerView mRecyclerView;
    private PictureListAdapter mPictureListAdapter;
    private IPicturePresenter mPicturePresenter;
    private static final int MESSAGE_UPDATE_LIST = 1;
    private List<PictureResponse> pictureResponseList = new ArrayList<>();



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
    protected void initListener() {
        mPictureListAdapter.setOnPictureItemClickListener(this);
    }

    @Override
    protected void loadData() {
        InnerHandler handler=new InnerHandler();
        mPicturePresenter.getPictures(getActivity(),handler);
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
        this.pictureResponseList = pictureResponseList;
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

    @Override
    public void onItemClick(PictureResponse item) {
        Intent intent = new Intent(getContext(),ShowPictureActivity.class);
        intent.putStringArrayListExtra("picture",new ArrayList<>(item.getMpic_url()));
        intent.putStringArrayListExtra("title",new ArrayList<>(item.getMtitle()));
        startActivity(intent);
    }

     class InnerHandler extends Handler{

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MESSAGE_UPDATE_LIST:
                    mPictureListAdapter.setmData(pictureResponseList);
                    setupState(State.SUCCESS);

                    break;


            }
        }
    }
}
