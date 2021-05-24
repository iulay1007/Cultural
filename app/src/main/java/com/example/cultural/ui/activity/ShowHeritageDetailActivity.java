package com.example.cultural.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.cultural.R;
import com.example.cultural.model.domain.HeritageResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShowHeritageDetailActivity extends AppCompatActivity {

    @BindView(R.id.activity_heritage_title_tv)
    public TextView heritage_title_tv;
    @BindView(R.id.activity_heritage_time_tv)
    public TextView activity_heritage_time_tv;

    @BindView(R.id.activity_heritage_type_tv)
    public TextView activity_heritage_type_tv;

    @BindView(R.id.activity_heritage_province_tv)
    public TextView activity_herige_province_tv;

    @BindView(R.id.activity_heritage_cate_tv)
    public TextView activity_heritage_cate_tv;

    @BindView(R.id.activity_heritage_area_tv)
    public TextView activity_heritage_area_tv;

    @BindView(R.id.activity_heritage_protect_unit_tv)
    public TextView activity_heritage_protect_unit_tv;

    @BindView(R.id.activity_heritage_content_tv)
    public TextView activity_heritage_content_tv;



    private Unbinder mBind = null;
    private String mtitle = "";
    private String mtime = "";
    private String mtype = "";
    private String mprovince = "";
    private String mcate = "";
    private String marea = " ";
    private String mprotect_unit = "";
    private String mcontent = "";

    public void setmData(List<HeritageResponse> mData) {
        this.mData = mData;
    }

    List<HeritageResponse> mData =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window=getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_show_heritage_detail);
        mBind = ButterKnife.bind(this);
        getIntentMsg();
        initView();
    }

    private void getIntentMsg() {
        Intent intent = getIntent();
        mtitle=intent.getStringExtra("title");
        mtime=intent.getStringExtra("time");
        mtype=intent.getStringExtra("type");
        mprovince=intent.getStringExtra("province");
        mcate=intent.getStringExtra("cate");
        marea=intent.getStringExtra("area");
        mprotect_unit=intent.getStringExtra("protect_unit");
        mcontent=intent.getStringExtra("content");

    }

    private void initView() {
        activity_heritage_content_tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        heritage_title_tv.setText(mtitle);
        activity_heritage_time_tv.setText(mtime);
        activity_heritage_type_tv.setText(mtype);
        activity_herige_province_tv.setText(mprovince);
        activity_heritage_cate_tv.setText(mcate);
        activity_heritage_area_tv.setText(marea);
        activity_heritage_protect_unit_tv.setText(mprotect_unit);
        activity_heritage_content_tv.setText(mcontent);


    }
}