package com.example.cultural.presenter;

import android.content.Context;

import com.example.cultural.base.IBasePresenter;
import com.example.cultural.view.IPictureCallback;

public interface IPicturePresenter extends IBasePresenter<IPictureCallback> {
    void getPictures(Context context);
}
