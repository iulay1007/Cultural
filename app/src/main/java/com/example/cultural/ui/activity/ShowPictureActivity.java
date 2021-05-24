package com.example.cultural.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.cultural.R;
import com.example.cultural.ui.adapter.ShowPictureListAdapter;
import com.example.cultural.utils.HorizontalItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShowPictureActivity extends AppCompatActivity {

    private List<String> mPictureList;
    private List<String> mTitleList;
    private ShowPictureListAdapter mShowPictureListAdapter;
    @BindView(R.id.recyclerview_show_picture)
    RecyclerView mRecyclerView;

    private Unbinder mBind = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window=getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_show_picture);
        mBind = ButterKnife.bind(this);
        getIntentMsg();
        initView();
        loadData();
    }

    private void loadData() {
        mShowPictureListAdapter.setData(mPictureList,mTitleList);
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        mShowPictureListAdapter = new ShowPictureListAdapter();
        mRecyclerView.setAdapter(mShowPictureListAdapter);
        mRecyclerView.addItemDecoration(new HorizontalItemDecoration(30));
    }

    private void getIntentMsg() {
       Intent intent = getIntent();
       mPictureList = intent.getStringArrayListExtra("picture");
       mTitleList = intent.getStringArrayListExtra("title");
       for(String i : mPictureList)
           Log.d("xx",i);
        for(String j : mTitleList)
            Log.d("xx",j);
        Log.d("xx",mPictureList.size()+" "+mTitleList.size());
    }
}