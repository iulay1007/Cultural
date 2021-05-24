package com.example.cultural.presenter.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Message;

import com.example.cultural.model.domain.PictureResponse;
import com.example.cultural.model.domain.QuizResponse;
import com.example.cultural.presenter.IQuizPresenter;
import com.example.cultural.view.IPictureCallback;
import com.example.cultural.view.IQuizCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class QuizPresenterImpl implements IQuizPresenter {
    private static final int MESSAGE_UPDATE_LIST = 1;
    private IQuizCallback mIQuizCallback = null;
    @Override
    public void getQuiz(Context context, Handler handler) {
        List<QuizResponse> responses =new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //TODO:Gson
                AssetManager assetManager=context.getAssets();
                Workbook workbook = null;

                try {

                    workbook = Workbook.getWorkbook(assetManager.open("zsc.xls"));
                    Sheet sheet = workbook.getSheet(0);
                    int rows=sheet.getRows();

                    for(int i=1;i<rows;i++){
                       responses.add(new QuizResponse(sheet.getCell(1,i).getContents(),sheet.getCell(2,i).getContents()));
                    }
                    mIQuizCallback.onQuizLoad(responses);
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
    public void registerViewCallback(IQuizCallback callback) {
        this.mIQuizCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IQuizCallback callback) {
        this.mIQuizCallback = null;
    }
}
