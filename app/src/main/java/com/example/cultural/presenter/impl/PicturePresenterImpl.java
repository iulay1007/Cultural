package com.example.cultural.presenter.impl;

import com.example.cultural.presenter.IPicturePresenter;
import com.example.cultural.view.IPictureCallback;

import java.util.ArrayList;

public class PicturePresenterImpl implements IPicturePresenter {
    private IPictureCallback mIPictureCallback = null;

    @Override
    public void getPictures() {
        mIPictureCallback.onPictureLoad(new ArrayList<>());
    }

    @Override
    public void registerViewCallback(IPictureCallback callback) {
        this.mIPictureCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IPictureCallback callback) {
        this.mIPictureCallback = null;
    }
}
