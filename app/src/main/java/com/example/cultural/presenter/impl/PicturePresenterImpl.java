package com.example.cultural.presenter.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Message;
import android.util.Log;

import com.example.cultural.base.BaseApplication;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.presenter.IPicturePresenter;
import com.example.cultural.view.IPictureCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PicturePresenterImpl implements IPicturePresenter {
    private static final int MESSAGE_UPDATE_LIST = 1;
    private IPictureCallback mIPictureCallback = null;

    @Override
    public void getPictures(Context context,Handler handler) {
        List<PictureResponse> responses =new ArrayList<>();
       new Thread(new Runnable() {
            @Override
            public void run() {
            //TODO:Gson
                AssetManager assetManager=context.getAssets();
                Workbook workbook = null;

                try {
                    List<String> mPictureList = new ArrayList<>();
                    List<String> mTitleList = new ArrayList<>();

                    workbook = Workbook.getWorkbook(assetManager.open("picture.xls"));
                    Sheet sheet = workbook.getSheet(0);
                    int rows=sheet.getRows();

                    for(int i=1;i<rows;i++){
                        Gson gson = new Gson();
                        mPictureList.clear();
                        mTitleList.clear();
                        mPictureList = gson.fromJson(sheet.getCell(4,i).getContents(), new  TypeToken<ArrayList<String>>(){}.getType());
                        mTitleList = gson.fromJson(sheet.getCell(5,i).getContents(), new  TypeToken<ArrayList<String>>(){}.getType());
                    responses.add(new PictureResponse(sheet.getCell(1,i).getContents(),sheet.getCell(3,i).getContents(),sheet.getCell(2,i).getContents(),new ArrayList<>(mPictureList),new ArrayList<>(mTitleList)));
                    }
                    mIPictureCallback.onPictureLoad(responses);
                    Message msg =Message.obtain(handler);
                    msg.what = MESSAGE_UPDATE_LIST;
                    handler.sendMessage(msg);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }finally {
                }
            }
        }).start();


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
