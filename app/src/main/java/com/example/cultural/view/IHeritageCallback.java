package com.example.cultural.view;

import com.example.cultural.base.IBaseCallback;
import com.example.cultural.model.domain.HeritageResponse;
import com.example.cultural.model.domain.PictureResponse;

import java.util.List;

public interface IHeritageCallback extends IBaseCallback {
    void onHeritage(List<HeritageResponse> heritageResponseList);
}
