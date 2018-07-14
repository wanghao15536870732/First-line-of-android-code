package com.example.lab.android.nuc.netorktest;

/**
 * Created by 王浩 on 2018/2/21.
 */

public interface HttpCallbackListener{
    void onFinish(String response);

    void onError(Exception e);
}
