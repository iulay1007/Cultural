package com.example.cultural.presenter;

import android.content.Context;
import android.os.Handler;

import com.example.cultural.base.IBasePresenter;
import com.example.cultural.view.IQuizCallback;

public interface IQuizPresenter extends IBasePresenter<IQuizCallback> {
    void getQuiz(Context context, Handler handler);
}
