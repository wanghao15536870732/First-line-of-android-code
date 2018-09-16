package com.example.lab.android.nuc.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;



public class MyIntentService extends IntentService  {

    public MyIntentService(String name) {
        super("MyIntentService");//调用父类的有参构造函数
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //打印当前线程的id
//        不用当心ANR的问题，因为该方法已经在子线程中运行的了
        Log.d("MyIntentService","Thread id is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService","onDestory executed");
    }
}
