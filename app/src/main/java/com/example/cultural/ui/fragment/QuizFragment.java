package com.example.cultural.ui.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;
import com.example.cultural.base.BaseFragment;
import com.example.cultural.model.domain.QuizResponse;
import com.example.cultural.presenter.IQuizPresenter;
import com.example.cultural.presenter.impl.QuizPresenterImpl;
import com.example.cultural.ui.adapter.PictureListAdapter;
import com.example.cultural.ui.adapter.QuizListAdapter;
import com.example.cultural.view.IQuizCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class QuizFragment extends BaseFragment implements IQuizCallback, QuizListAdapter.onQuizItemClickListener {

    private static final int MESSAGE_UPDATE_LIST = 1;
    @BindView(R.id.quiz_recyclerview)
    RecyclerView mRecyclerView;

    QuizListAdapter mQuizListAdapter;
    IQuizPresenter mIQuizPresenter;
    List<QuizResponse> list = new ArrayList<>();
    List<Boolean> clickList = new ArrayList<>();

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_quiz;
    }

    @Override
    protected void initListener() {
        mQuizListAdapter.setOnQuizItemClickListener(this);
    }

    @Override
    protected void initPresenter() {
        mIQuizPresenter = new QuizPresenterImpl();
        mIQuizPresenter.registerViewCallback(this);
    }

    @Override
    protected void initView(View rootView) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        mQuizListAdapter = new QuizListAdapter();
        mRecyclerView.setAdapter(mQuizListAdapter);

    }

    @Override
    public void onQuizLoad(List<QuizResponse> quizResponseList) {
        this.list = quizResponseList;
        for(int i=0;i<quizResponseList.size();i++)
            clickList.add(false);
    }

    @Override
    protected void loadData() {
        InnerHandler handler=new InnerHandler();
        mIQuizPresenter.getQuiz(getContext(),handler);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onItemClick(QuizResponse item, QuizListAdapter.InnerHolder holder,int position) {
        if(clickList.get(position)!=false){
        holder.quiz_answer_tv.setVisibility(View.GONE);
        clickList.set(position,false);
        }else   {holder.quiz_answer_tv.setVisibility(View.VISIBLE);
        clickList.set(position,true);
        }
    }

    class InnerHandler extends Handler{


        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MESSAGE_UPDATE_LIST:
                    mQuizListAdapter.setData(list);
                    setupState(State.SUCCESS);

                    break;


            }
        }
    }
}

