package com.example.cultural.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultural.R;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.model.domain.QuizResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.InnerHolder> {

    private List<QuizResponse> list = new ArrayList<>();

    public void setOnQuizItemClickListener(QuizListAdapter.onQuizItemClickListener onQuizItemClickListener) {
        this.onQuizItemClickListener = onQuizItemClickListener;
    }

    private onQuizItemClickListener onQuizItemClickListener;
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz,parent,false);

        return new QuizListAdapter.InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  QuizListAdapter.InnerHolder holder, int position) {
        QuizResponse bean = list.get(position);
        holder.setmData(bean.getQuestion(),bean.getAnswer());
        holder.quiz_answer_tv.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onQuizItemClickListener.onItemClick(bean,holder,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 10;
    }

    public void setData(List<QuizResponse> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public interface onQuizItemClickListener{
        void onItemClick(QuizResponse item,QuizListAdapter.InnerHolder holder,int position);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.quiz_question_tv)
        public TextView quiz_question_tv;
        @BindView(R.id.quiz_answer_tv)
        public TextView quiz_answer_tv;
        public InnerHolder(@NonNull  View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        void setmData(String question,String answer){
            quiz_question_tv.setText(question);
            quiz_answer_tv.setText(answer);
        }
    }
}
