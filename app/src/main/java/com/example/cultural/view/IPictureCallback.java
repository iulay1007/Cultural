package com.example.cultural.view;

import com.example.cultural.base.IBaseCallback;
import com.example.cultural.base.IBasePresenter;
import com.example.cultural.model.domain.PictureResponse;

import java.util.List;

public interface IPictureCallback extends IBaseCallback {
    void onPictureLoad(List<PictureResponse> pictureResponseList);
}
