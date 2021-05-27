package com.example.cultural.ui.fragment;

import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;
import com.example.cultural.base.BaseFragment;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.presenter.impl.NewsPresenterImpl;
import com.example.cultural.ui.adapter.NewsListAdapter;
import com.example.cultural.view.INewsCallback;

import java.util.List;

import butterknife.BindView;

public class NewsFragment extends BaseFragment implements INewsCallback {

    @BindView(R.id.recyclerview_news)
    public RecyclerView mRecyclerView;

    private NewsListAdapter newsListAdapter;
    private NewsPresenterImpl newsPresenter;



    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initPresenter() {
        newsPresenter = new NewsPresenterImpl();
        newsPresenter.registerViewCallback(this);
    }

    @Override
    protected void initView(View rootView) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //mRecyclerView.addItemDecoration(new ItemDecoration(20));
        // mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        newsListAdapter = new NewsListAdapter();
        mRecyclerView.setAdapter(newsListAdapter);

    }

    @Override
    protected void loadData() {
        //TODO
        newsPresenter.getNews(getActivity(),new Handler());
    }


    @Override
    public void onNewsLoad(List<PictureResponse> pictureResponseList) {
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
