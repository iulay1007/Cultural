package com.example.cultural.view;

import com.example.cultural.base.IBaseCallback;
import com.example.cultural.model.domain.PictureResponse;

import java.util.List;

public interface INewsCallback extends IBaseCallback {
    void onNewsLoad(List<PictureResponse> pictureResponseList);

}
