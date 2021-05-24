package com.example.cultural.presenter;

import android.content.Context;

import com.example.cultural.base.IBasePresenter;
import com.example.cultural.view.IPictureCallback;
import android.os.Handler;


public interface IPicturePresenter extends IBasePresenter<IPictureCallback> {
    void getPictures(Context context, Handler handler);
}
