package com.example.lab.android.nuc.servicebestpractice;

import android.os.AsyncTask;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DownloadTask extends AsyncTask<String,Integer,Integer>{

    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSE = 2;
    public static final int TYPE_CANCELED = 3;

    private DownloadListener listener;

    private boolean isCanceled = false;

    private boolean isPaused = false;

    private int lastProgress;

    public DownloadTask(DownloadListener listener){
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... param) {
        InputStream is = null;
        RandomAccessFile saveFile = null;
        File file = null;
        try {
            long downloadedLength = 0; //记录已下载的文件长度
            String downloadUrl = param[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory
                    (Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory + fileName);
            if (file.exists()){
                downloadedLength = file.length();
            }
            long contentLength = getContentLength(downloadUrl);
            if (contentLength == 0){ //如果进度为0，则返回下载失败
                return TYPE_FAILED;
            }else if (contentLength == downloadedLength){
//                以下载字节和文件总字节相等，说明已经下载完了
                return TYPE_SUCCESS;
            }
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE","bytes = " + downloadedLength + "-")
                    .url(downloadUrl)
                    .build();
//                    断点下载，指定从那个字节开始下载
            Response response = client.newCall(request).execute();
            if (request != null){
                is = response.body().byteStream();
                saveFile = new RandomAccessFile(file,"rw");
                saveFile.seek(downloadedLength);//跳过已经下载的字节
                byte[] b = new byte[1024];
                int total = 0;
                int len;
                while ((len = is.read(b)) != -1){
                    if (isCanceled){
                        return TYPE_CANCELED;
                    }else if (isPaused){
                        return TYPE_PAUSE;
                    }else {
                        total += len;
                        saveFile.write(b,0,len);
//                        计算已下载的百分比、
                        int progress = (int) ((total + downloadedLength) * 100 / contentLength);
                        publishProgress(progress);
                    }
                }
                response.body().close();
                return TYPE_SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (is != null){
                    is.close();
                }
                if (saveFile != null){
                    saveFile.close();
                }
                if (isCanceled && file != null){
                    file.delete();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return TYPE_FAILED;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if (progress > lastProgress){
            listener.onProgress(progress);
            lastProgress = progress;
        }
    }

    @Override
    protected void onPostExecute(Integer status) {
        switch (status){
            case TYPE_SUCCESS:
                listener.onSuccess();
                break;
            case TYPE_FAILED:
                listener.onFailed();
                break;
            case TYPE_PAUSE:
                listener.onPaused();
                break;
            case TYPE_CANCELED:
                listener.onCanceled();
                break;
            default:
                break;
        }
    }

    public void pauseDownload(){
        isPaused = true;
    }

    public void cancelDownload(){
        isCanceled = true;
    }

    private long getContentLength(String downloadUrl) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response response = client.newCall(request).execute();
        if (response != null && response.isSuccessful()){
            long contentLength = response.body().contentLength();
            response.close();
            return contentLength;
        }
        return 0;
    }


}
