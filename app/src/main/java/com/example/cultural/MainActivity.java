package com.example.cultural;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.cultural.base.BaseApplication;
import com.example.cultural.base.BaseFragment;
import com.example.cultural.model.API;
import com.example.cultural.model.domain.IntangibleCulturalHeritage;
import com.example.cultural.ui.fragment.CulturalHeritageFragment;
import com.example.cultural.ui.fragment.PictureFragment;
import com.example.cultural.ui.fragment.ProtectionZoneFragment;
import com.example.cultural.ui.fragment.QuizFragment;
import com.example.cultural.utils.RetrofitManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView navigationView;
    private Unbinder mBind;
    private FragmentManager fm;
    private CulturalHeritageFragment mCulturalHeritageFragment;
    private PictureFragment mPictureFragment;
    private ProtectionZoneFragment mProtectionZoneFragment;
    private QuizFragment mQuizFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragment();
        initListener();

     /*   Retrofit retrofit= RetrofitManager.getInstance().getRetrofit();
        API api =retrofit.create(API.class);
        Call<IntangibleCulturalHeritage> task=api.getIntangibleCulturalHeritage();
        task.enqueue(new Callback<IntangibleCulturalHeritage>() {
            @Override
            public void onResponse(Call<IntangibleCulturalHeritage> call, Response<IntangibleCulturalHeritage> response) {
              IntangibleCulturalHeritage intangibleCulturalHeritage = response.body();
                Log.d("MainResult",intangibleCulturalHeritage.getList().get(3).getTitle());
            }

            @Override
            public void onFailure(Call<IntangibleCulturalHeritage> call, Throwable t) {
            t.fillInStackTrace();
            Log.d("q","errorrrr");
            }
        });
        Thread thread =new th();
        thread.start();*/

    }

    private void initListener() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==R.id.cultural_heritage){
                switchFragment(mCulturalHeritageFragment);
            }else if(item.getItemId()==R.id.protection_zone){
                switchFragment(mProtectionZoneFragment);
            }
            else if(item.getItemId()==R.id.picture){
                switchFragment(mPictureFragment);
            }
            else if(item.getItemId()==R.id.quiz){
                switchFragment(mQuizFragment);
            }
            return true;
        }
    });
    }

    //上一次显示的fragment
    private BaseFragment lastOneFragment = null;

    private void switchFragment(BaseFragment targetFragment) {
        //用add和hide的方式来控制fragment的切换
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        if (!targetFragment.isAdded()) {
            fragmentTransaction.add(R.id.main_page_container,targetFragment);
        }else {

            fragmentTransaction.show(targetFragment);
        }
        if (lastOneFragment != null) {
            fragmentTransaction.hide(lastOneFragment);
        }
        lastOneFragment = targetFragment;
        //fragmentTransaction.replace(R.id.main_page_container,targetFragment);
        fragmentTransaction.commit();
    }

    private void initFragment() {
        mCulturalHeritageFragment = new CulturalHeritageFragment();
        mPictureFragment = new PictureFragment();
        mProtectionZoneFragment = new ProtectionZoneFragment();
        mQuizFragment = new QuizFragment();
        fm = getSupportFragmentManager();
        switchFragment(mPictureFragment);
    }

    class th extends Thread{
        @Override
        public void run() {
            AssetManager assetManager = getAssets();

                Log.d("www","qq");


            Workbook workbook = null;
            try {

                workbook = Workbook.getWorkbook(assetManager.open("qwqt.xls"));
                Sheet sheet = workbook.getSheet(0);
                Log.d("q",sheet.getCell(1,1).getContents());
                Log.d("www","qq2");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }



        }
    }


}