package com.example.cultural.presenter.impl;

import android.content.Context;
import android.os.Handler;

import com.example.cultural.presenter.INewsPresenter;
import com.example.cultural.view.INewsCallback;
import com.example.cultural.view.IPictureCallback;

import java.util.ArrayList;

public class NewsPresenterImpl implements INewsPresenter {
    private static final int MESSAGE_UPDATE_LIST = 1;
    private INewsCallback mINewsCallback = null;

    @Override
    public void getNews(Context context, Handler handler) {
        mINewsCallback.onNewsLoad(new ArrayList<>());
    }

    @Override
    public void registerViewCallback(INewsCallback callback) {
        this.mINewsCallback = callback;
    }

    @Override
    public void unregisterViewCallback(INewsCallback callback) {
        this.mINewsCallback = null;
    }
}
