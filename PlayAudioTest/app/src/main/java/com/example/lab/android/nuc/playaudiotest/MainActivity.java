package com.example.lab.android.nuc.playaudiotest;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//    private final int PLAY_RANDOM = R.drawable.ic_play_arrow_black_24dp;
//
//    private final int PLAY_QUEUE = R.drawable.ic_pause_black_24dp;
//
//    private int REPEAT_ONE = R.drawable.ic_stop_black_24dp;
//
//
//    private int playMode = PLAY_RANDOM;
//
//    private int songIndex = -1;

    SeekBar seekBar;

//    首先创建了一个MediaPlayer实例
    private MediaPlayer mediaPlayer = new MediaPlayer();

//    创建了一个VideoView的实例
    private VideoView videoView;

    public static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        音乐播放器的逻辑
        final Button play = (Button) findViewById(R.id.play);
        Button pause = (Button) findViewById(R.id.pause);
        Button stop = (Button) findViewById(R.id.stop);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

        //        视频播放器的逻辑
        videoView = (VideoView) findViewById(R.id.video_view);
        Button play1 = (Button) findViewById(R.id.play1);
        Button pause1 = (Button) findViewById(R.id.pause1);
        Button replay = (Button) findViewById(R.id.replay);
        play1.setOnClickListener(this);
        pause1.setOnClickListener(this);
        replay.setOnClickListener(this);

        seekBar = (SeekBar) findViewById(R.id.SeekBar_view);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (mediaPlayer != null && fromUser){
                    mediaPlayer.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.
            WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }else {
            initMediaPlayer();//初始化MediaPlayer()
            initVideoPath();
        }

    }



//    同步SeekBar与进度条时间
    private void updataSeekBar(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;  //获取mediaPlayer当前进度，毫秒表示
                    int total = mediaPlayer.getDuration() / 1000; //获取当前歌曲的总时长
                    seekBar.setMax(total); //seekBar设置总时长

                }
                handler.postDelayed(this,100);//延迟一秒运行线程
            }
        });
    }

    //计算歌曲的时间
    public String calculateTime(int time){
        int minute;
        int second;
        if (time > 60){
            minute = time / 60;
            second = time % 60;
            return minute + ":" + second;
        }else if (time < 60){
            second = time;
            return 0 + ":" + second;
        }
        return null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initMediaPlayer();
                    initVideoPath();
                }else {
                    Toast.makeText(this,"拒绝权限将无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    private void initMediaPlayer(){
        try{
            File file = new File(Environment.getExternalStorageDirectory(),
                    "说散就散 - 冯提莫.mp3");
            mediaPlayer.setDataSource(file.getPath());//指定音频文件的路径
            mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initVideoPath() {
        File file1 = new File(Environment.getExternalStorageDirectory(),"movie.mp4");
        videoView.setVideoPath(file1.getPath());//指定视频文件的路径
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.play:
//                如果们没有有在播放
                if (!mediaPlayer.isPlaying()){
//                    开始播放
                    mediaPlayer.start();
                    updataSeekBar();
                }
                File file = new File(Environment.getExternalStorageDirectory(),
                        "说散就散 - 冯提莫.mp3");
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle(file.getName())
                        .setContentText("音乐文件位置：" + file.getPath())
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .build();
                manager.notify(1,notification);
                break;
            case R.id.pause:
//            如果正在播放
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                break;
            case R.id.stop:
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.reset();//停止播放
                    initMediaPlayer();//再次调用
                }
                break;
            case R.id.play1:
                if (!videoView.isPlaying()){
                    videoView.start();//开始播放
                }
                break;
            case R.id.pause1:
                if (videoView.isPlaying()){
                    videoView.pause();//暂停播放
                }
                break;
            case R.id.replay:
                if (videoView.isPlaying()){
                    videoView.resume();//重新播放
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        如果
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        if (videoView != null){
            videoView.suspend();
        }
    }
}
