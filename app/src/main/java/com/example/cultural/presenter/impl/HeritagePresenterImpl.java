package com.example.cultural.presenter.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.cultural.model.domain.HeritageResponse;
import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.presenter.IHeritagePresenter;
import com.example.cultural.view.IHeritageCallback;
import com.example.cultural.view.IPictureCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class HeritagePresenterImpl implements IHeritagePresenter {
    private static final int MESSAGE_UPDATE_LIST = 1;
    private IHeritageCallback mIHeritageCallback = null;


    @Override
    public void getHeritage(Context context, Handler handler) {
        List<HeritageResponse> responses =new ArrayList<>();
        //TODO:
        new Thread(new Runnable() {
            @Override
            public void run() {
                //TODO:Gson
                AssetManager assetManager=context.getAssets();
                Workbook workbook = null;

                try {
                    List<String> mInfoList = new ArrayList<>();

                    workbook = Workbook.getWorkbook(assetManager.open("heritage.xls"));
                    Sheet sheet = workbook.getSheet(0);
                    int rows=sheet.getRows()/5;

                    for(int i=1;i<rows;i++){
                        Gson gson = new Gson();
                        mInfoList.clear();
                        mInfoList = gson.fromJson(sheet.getCell(6,i).getContents(), new  TypeToken<ArrayList<String>>(){}.getType());
                        responses.add(new HeritageResponse(sheet.getCell(1,i).getContents(),sheet.getCell(2,i).getContents(),sheet.getCell(3,i).getContents(),sheet.getCell(4,i).getContents(),sheet.getCell(5,i).getContents(),new ArrayList<>(mInfoList),sheet.getCell(7,i).getContents()));
                    for(String k : mInfoList)
                        Log.d("yy",i+" "+k);
                        Log.d("yy",i+" "+mInfoList.size());
                    }
                    mIHeritageCallback.onHeritage(responses);
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
        mIHeritageCallback.onHeritage(new ArrayList<>());
    }


    @Override
    public void registerViewCallback(IHeritageCallback callback) {
        this.mIHeritageCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IHeritageCallback callback) {
        this.mIHeritageCallback = null;
    }
}
