package com.example.cultural.presenter;

import android.content.Context;
import android.os.Handler;

import com.example.cultural.base.IBasePresenter;
import com.example.cultural.view.INewsCallback;


public interface INewsPresenter extends IBasePresenter<INewsCallback> {
    void getNews(Context context, Handler handler);
}
