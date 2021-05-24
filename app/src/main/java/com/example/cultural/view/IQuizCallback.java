package com.example.cultural.view;

import com.example.cultural.base.IBaseCallback;
import com.example.cultural.model.domain.QuizResponse;


import java.util.List;

public interface IQuizCallback extends IBaseCallback {
    void onQuizLoad(List<QuizResponse> quizResponseList);
}
