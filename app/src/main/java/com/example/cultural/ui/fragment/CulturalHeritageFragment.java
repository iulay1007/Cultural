package com.example.cultural.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;
import com.example.cultural.base.BaseFragment;
import com.example.cultural.model.domain.HeritageResponse;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.presenter.IHeritagePresenter;
import com.example.cultural.presenter.impl.HeritagePresenterImpl;
import com.example.cultural.ui.activity.ShowHeritageDetailActivity;
import com.example.cultural.ui.activity.ShowPictureActivity;
import com.example.cultural.ui.adapter.HeritageListAdapter;
import com.example.cultural.ui.adapter.PictureListAdapter;
import com.example.cultural.view.IHeritageCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CulturalHeritageFragment extends BaseFragment implements IHeritageCallback, HeritageListAdapter.onHeritageItemClickListener {

    private static final int MESSAGE_UPDATE_LIST = 1;
    @BindView(R.id.recyclerview_heritage)
    public RecyclerView mRecyclerView;

    private HeritageListAdapter mHeritageListAdapter;
    private IHeritagePresenter mIHeritagePresenter;
    private List<HeritageResponse> mHeritageResponseList = new ArrayList<>();

    @Override
    protected int getRootViewResId() {
        Log.d("fragment","fragment_cultural_heritage");
        return R.layout.fragment_cultural_heritage;
    }

    @Override
    protected void initPresenter() {
        mIHeritagePresenter =new HeritagePresenterImpl();
        mIHeritagePresenter.registerViewCallback(this);
    }



    @Override
    protected void initView(View rootView) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mHeritageListAdapter = new HeritageListAdapter();
        mRecyclerView.setAdapter(mHeritageListAdapter);
    }

    @Override
    protected void initListener() {
        mHeritageListAdapter.setOnHeritageItemClickListener(this);
    }

    @Override
    protected void loadData() {
        InnerHandler handler=new InnerHandler();
        Log.d("lo","loadingdata");
        mIHeritagePresenter.getHeritage(getActivity(),handler);
    }

    @Override
    public void onHeritage(List<HeritageResponse> heritageResponseList) {
        this.mHeritageResponseList = heritageResponseList;
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
    public void onItemClick(HeritageResponse item) {
        Intent intent =new Intent(getContext(),ShowHeritageDetailActivity.class);
        intent.putExtra("title",item.getTitle());
        intent.putExtra("time",item.getInfo().get(2));
        intent.putExtra("type",item.getInfo().get(3));
        intent.putExtra("province",item.getInfo().get(4));
        intent.putExtra("cate",item.getInfo().get(5));
        intent.putExtra("area",item.getInfo().get(6));
        intent.putExtra("protect_unit",item.getInfo().get(7));
        intent.putExtra("content",item.getContent());
        startActivity(intent);
    }

    class InnerHandler extends Handler{

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MESSAGE_UPDATE_LIST:
                    mHeritageListAdapter.setmdata(mHeritageResponseList);
                    setupState(State.SUCCESS);

                    break;


            }
        }
    }
}
