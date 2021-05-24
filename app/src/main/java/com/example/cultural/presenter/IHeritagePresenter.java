package com.example.cultural.presenter;

import android.content.Context;
import android.os.Handler;

import com.example.cultural.base.IBasePresenter;
import com.example.cultural.view.IHeritageCallback;

public interface IHeritagePresenter extends IBasePresenter<IHeritageCallback> {
    void getHeritage(Context context, Handler handler);
}
