package com.example.lab.android.nuc.servicebestpractice;

public interface DownloadListener{

//    用于通知下载进度
    void onProgress(int progress);
//    通知下载成功事件
    void onSuccess();
//    通知下载失败事件
    void onFailed();
//    通知下载停止事件
    void onPaused();
//    通知下载取消事件
    void onCanceled();
}
